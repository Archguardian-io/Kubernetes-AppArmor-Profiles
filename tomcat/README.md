# AppArmor and Seccomp profiles for tomcat
## Command that was used for running tomcat
&nbsp;
```bash
helm install tomcat bitnami/tomcat --version 11.2.17
```
## Tests for profiling the container
&nbsp;
```bash
until curl -Ls $1
do
  sleep 2
done

curl -Ls $1
curl -Ls $1
curl -Ls $1
curl -Ls ${1}/index.html
curl -Ls ${1}/robots.txt
curl -Ls ${1}/404.html
dirb http://${1}:80
#gospider -s http://${1}:80
```
## Bash script to update the helm chart
&nbsp;
```bash
dir=$(realpath $(dirname $0))
sed -i "/podAnnotations.*/ s|{}|{container.apparmor.security.beta.kubernetes.io/tomcat: localhost/bitnamitomcat.aa}|" $dir/values.yaml
yq -i ".containerSecurityContext.seccompProfile.type = \"Localhost\"" $dir/values.yaml
yq -i ".containerSecurityContext.seccompProfile.localhostProfile = \"bitnamitomcat.sc\"" $dir/values.yaml
```
