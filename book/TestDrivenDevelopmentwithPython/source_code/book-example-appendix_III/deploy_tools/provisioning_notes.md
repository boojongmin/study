신규 사이트 프로비저닝
=======================

## ansible 사용

    ansible-playbook -i ansible.inventory provision.ansible.yaml --limit=staging

localhost에서 sudo 패스워드가 필요한 경우 `--ask-sudo-pass` 추가

    ansible-playbook -i ansible.inventory provision.ansible.yaml --limit=local --ask-sudo-pass

## 폴더 구조
사용자 계정이 /home/username라고 가정

/home/username
└── sites
    └── SITENAME
         ├── database
         ├── source
         ├── static
         └── virtualenv
