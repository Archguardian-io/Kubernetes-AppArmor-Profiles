# AppArmor and Seccomp profiles for grafana
## Command that was used for running grafana
&nbsp;
```bash
helm install grafana grafana/grafana --version 8.4.8
```
## Tests for profiling the container
&nbsp;
```bash
until curl -Ls ${1}:80
do
  sleep 2
done

curl -Ls ${1}:80 ||:
curl -Ls ${1}:80 ||:
curl -Ls ${1}:80 ||:
curl -Ls ${1}:80/api/ ||:
curl -Ls ${1}:80/api/ ||:
curl -Ls ${1}:80/api/health ||:
curl -Ls ${1}:80/api/health ||:
curl -Ls ${1}:80/api/health ||:
dirb http://${1}:80 ||:
```
## Bash script to update the helm chart
&nbsp;
```bash
dir=$(realpath $(dirname $0))
sed -i "s|# podAnnotations:.*|podAnnotations: {container.apparmor.security.beta.kubernetes.io/grafana: localhost/grafanagrafana.aa}|" $dir/values.yaml
yq -i ".containerSecurityContext.seccompProfile.type = \"Localhost\"" $dir/values.yaml
yq -i ".containerSecurityContext.seccompProfile.localhostProfile = \"grafanagrafana.sc\"" $dir/values.yaml
```
