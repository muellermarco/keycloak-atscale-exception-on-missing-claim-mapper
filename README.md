# Keycloak - Custom identity provider mapper

So far only the mapper UI with the properties has been implemented. Next step is to create an exception on the missing claim specified.


As other [Keycloak SPI](https://www.keycloak.org/docs/latest/server_development/index.html#_implementing_spi),
* put jar file in ```/providers``` folder
* if Keycloak server il already started, stop it
* to take into account this new provider, launch following command ```/bin/kc.sh build```
* and start Keycloak server again ```/bin/kc.sh start```

## Development



### Build

To build your local package, execute following command ```mvnw package```

### Container

To test a provider, set version of your provider (jar file) in .env file :
```MAPPER_VERSION=2.0.0```

add the jar to the /providers folder, example for docker compose:
```
    volumes:
      - "keycloak-atscale-exception-on-missing-claim-mapper-3.0.0.jar:/opt/bitnami/keycloak/providers/keycloak-atscale-exception-on-missing-claim-mapper-3.0.0.jar"
```