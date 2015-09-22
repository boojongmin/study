from fabric.contrib.files import append, exists, sed
from fabric.api import env, local, run
import random

env.hosts = ['elspeth@172.17.0.1']

REPO_URL = 'git@github.com:boojongmin/study.git'
BRANCH_NAME = 'python'
SERVER_REPO_URL = 'ssh://55f90e4789f5cfb7a00000b0@python-boojongmin.rhcloud.com/~/git/python.git/'
DEPLOY_SOURCE_SRC = 'book/TestDrivenDevelopmentwithPython/example/superlists'

def deploy():
    site_folder = '/home/%s/sites/%s' % (env.user, env.host)
    source_folder = site_folder + '/source'
    # run('su -l')
    # insert private method
    _create_directory_structure_if_necessary(site_folder)
    _get_last_source(source_folder)
    _get_last_deploy(source_folder)
    # _update_virtualenv(source_folder)

def _create_directory_structure_if_necessary(site_folder):
    for subfolder in ('database', 'static', 'virtualenv', 'source', 'deploy'):
        run('mkdir -p %s/%s' % (site_folder, subfolder))

def _get_last_source(source_folder):
    if exists(source_folder + '/.git'):
        run('cd %s && git fetch' % (source_folder,))
    else:
        run('git clone -b %s %s %s' % (BRANCH_NAME, REPO_URL, source_folder, ))
    current_commit = local("git log -n 1 --format=%H", capture=True)
    run('cd %s && git reset --hard %s' % (source_folder, current_commit))

def _get_last_deploy(source_folder):
    run('cd %s && rm -rf ./*' % (source_folder + '/../deploy/') )
    run('cp -r %s/%s/* %s' % (source_folder, DEPLOY_SOURCE_SRC, source_folder + '/../deploy/',) )


def _update_virtualenv(source_folder):
    virtualenv_folder = source_folder + '/../virtualenv'
    if not exists(virtualenv_folder + '/bin/pip'):
        run('virtualenv --python=python3 %s' (firtualenv_folder, ))
    run('%s/bin/pip install -r %s/requirements.txt' % (virtualenv_folder, source_folder, ))

def _update_static_files(source_folder):
    run('cd %s && ../virtualenv/bin/python3 manage.py collectstatic --noinput' % (source_folder, ))
