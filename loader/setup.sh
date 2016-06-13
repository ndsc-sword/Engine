#!/bin/bash

sudo locale-gen en_US.UTF-8
export LC_ALL=C

sudo apt-get -y update
sudo apt-get -y upgrade
    
if [ ! -d loaderEnvironment ]; then 

	if !(hash git 2>/dev/null); then
		sudo apt-get -y install git
	fi

	if !(hash pip 2>/dev/null); then
		sudo apt-get -y install python-pip
	fi

	if !(hash virtualenv 2>/dev/null); then
		sudo pip install virtualenv
	fi

    if !(hash python3-dev 2>/dev/null); then
        sudo apt-get -y install python3-dev
	fi

    if !(hash automake 2>/dev/null); then
        sudo apt-get -y install automake
    fi

    if !(hash tmux 2>/dev/null); then
        sudo apt-get -y install tmux
    fi

	virtualenv -p /usr/bin/python3 loaderEnvironment
fi

source loaderEnvironment/bin/activate

pip install -r requirements.txt




	
deactivate
