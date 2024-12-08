# AppArmor and Seccomp profiles for prometheus
## Command that was used for running prometheus
&nbsp;
```bash
helm install prometheus prometheus-community/prometheus --version 25.26.0
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
```
## Bash script to update the helm chart
&nbsp;
```bash
dir=$(realpath $(dirname $0))
sed -i "/podAnnotations.*/ s|{}|{container.apparmor.security.beta.kubernetes.io/prometheus-server: localhost/quay.ioprometheusprometheus.aa}|" $dir/values.yaml
yq -i ".server.containerSecurityContext.seccompProfile.type = \"Localhost\"" $dir/values.yaml
yq -i ".server.containerSecurityContext.seccompProfile.localhostProfile = \"quay.ioprometheusprometheus.sc\"" $dir/values.yaml
```
