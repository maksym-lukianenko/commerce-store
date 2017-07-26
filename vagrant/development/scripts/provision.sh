#!/bin/bash

installMate()
{
  sudo yum -y install epel-release
  sudo yum -y groupinstall "X Window System"
  sudo yum -y groupinstall "MATE Desktop"
  sudo systemctl set-default graphical.target
  sudo systemctl start graphical.target
}

installArchiveTools()
{
  sudo yum -y install unzip
  sudo yum -y install gzip
  sudo yum -y install zip
  sudo yum -y install tar
}

installNetworkTools()
{
  sudo yum -y install wget
}

installSdkman()
{
  curl -s "https://get.sdkman.io" | bash
  source "$HOME/.sdkman/bin/sdkman-init.sh"
}

installLanguages()
{
  sdk install java
  sdk install groovy
  sdk install kotlin
}

installTools()
{
  sdk install gradle
  sudo yum -y install https://centos7.iuscommunity.org/ius-release.rpm
  sudo yum -y install git2u
}

installIdea()
{
  cd $HOME
  echo "Downloading IDEA"
  wget https://download-cf.jetbrains.com/idea/ideaIC-2017.1.5-no-jdk.tar.gz >/dev/null 2>&1
  echo 'Installing IDEA'
  for file in `ls idea*.tar.gz`
  do 
    echo "Extracting $file"
    tar xvzf ./$file
    file $file
    #tar xvzf $file
  done
  rm idea*.tar.gz
}

installPostgres()
{
  wget https://download.postgresql.org/pub/repos/yum/9.6/redhat/rhel-7-x86_64/pgdg-centos96-9.6-3.noarch.rpm
  sudo yum -y install pgdg-centos96-9.6-3.noarch.rpm epel-release
  sudo yum -y update
  sudo yum -y install postgresql96-server postgresql96-contrib
  sudo /usr/pgsql-9.6/bin/postgresql96-setup initdb
  sudo systemctl start postgresql-9.6
  sudo systemctl enable postgresql-9.6
  sudo systemctl start postgresql-9.6
  
  sudo -u postgres psql -c "ALTER USER postgres WITH encrypted PASSWORD 'postgres';"
  sudo -u postgres psql -c "CREATE SCHEMA estore;"
  
  rm pgdg-centos96-9.6-3.noarch.rpm
  
  configurePostgres
}

configurePostgres()
{
  sudo cp /shared/config/postgres/pg_hba.conf /var/lib/pgsql/9.6/data/pg_hba.conf
  sudo cp /shared/config/postgres/postgresql.conf /var/lib/pgsql/9.6/data/postgresql.conf
  sudo systemctl restart postgresql-9.6
}

run() {
  installMate
  installArchiveTools
  installNetworkTools
  installSdkman
  installLanguages
  installTools
  installIdea
  installPostgres
}

if [ ! -f "/var/vagrant_provision" ]; then
  sudo touch /var/vagrant_provision
  run
else
  echo "Nothing to do"
fi