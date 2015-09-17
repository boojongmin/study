from fabric.contrib.files import append, exists, sed
from fabric.api import env, local, run
import random

REPO_URL = 'git@github.com:boojongmin/study.git'
SERVER_REPO_URL = 'ssh://55f90e4789f5cfb7a00000b0@python-boojongmin.rhcloud.com/~/git/python.git/'

def deploy():
    site_folder = '/home/%s/sites/%s' % (env.user, env.host)
    source_folder = site_folder + '/source'
    # insert private method
    _create_directory_structure_if_necessary(site_folder)
    _update_virtualenv(source_folder):

def _create_directory_structure_if_necessary(site_folder):
    for subfolder in ('database', 'static', 'virtualenv', 'source'):
        run('mkdir -p %s/%s' % (site_folder, subfolder))

def _update_virtualenv(source_folder):
    virtualenv_folder = source_folder + '/../virtualenv'
    if not exists(virtualenv_folder + '/bin/pip'):
        run('virtualenv --python=python3 %s' (firtualenv_folder, ))
    run('%s/bin/pip install -r %s/requirements.txt' % (virtualenv_folder, source_folder, ))
