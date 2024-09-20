# AppArmor and Seccomp profiles for postgresql
## Command that was used for running postgresql
&nbsp;
```bash
helm install postgresql bitnami/postgresql --version 15.5.24
```
## Tests for profiling the container
&nbsp;
```bash
until pg_isready -h $1 -p 5432 -U postgres
do
  sleep 2
done

PGPASSWORD=password psql -h $1 -p 5432 -U postgres -c "CREATE DATABASE testdb;" ||:
PGPASSWORD=password psql -h $1 -p 5432 -U postgres -d testdb -c "CREATE TABLE testtable (id SERIAL PRIMARY KEY, value VARCHAR(50));" ||:
PGPASSWORD=password psql -h $1 -p 5432 -U postgres -d testdb -c "INSERT INTO testtable (value) VALUES ('Hello, World!');" ||:
PGPASSWORD=password psql -h $1 -p 5432 -U postgres -d testdb -c "SELECT * FROM testtable;" ||:
PGPASSWORD=password psql -h $1 -p 5432 -U postgres -d testdb -c "select 1;" ||:
PGPASSWORD=password psql -h $1 -p 5432 -U postgres -d testdb -c "select 2;" ||:
PGPASSWORD=password psql -h $1 -p 5432 -U postgres -d testdb -c "select 3;" ||:
PGPASSWORD=password psql -h $1 -p 5432 -U postgres -d testdb -c "select 2 + 2;" ||:
PGPASSWORD=password psql -h $1 -p 5432 -U postgres -d testdb -c "select version();" ||:
PGPASSWORD=password psql -h $1 -p 5432 -U postgres -d testdb -c "select current_date;" ||:
PGPASSWORD=password pgbench -h $1 -p 5432 -U postgres -i -s 50 testdb
```
## Bash script to update the helm chart
&nbsp;
```bash
dir=$(realpath $(dirname $0))
sed -i "/podAnnotations.*/ s|{}|{container.apparmor.security.beta.kubernetes.io/postgresql: localhost/bitnamipostgresql.aa}|" $dir/values.yaml
yq -i ".primary.containerSecurityContext.seccompProfile.type = \"Localhost\"" $dir/values.yaml
yq -i ".primary.containerSecurityContext.seccompProfile.localhostProfile = \"bitnamipostgresql.sc\"" $dir/values.yaml
```
