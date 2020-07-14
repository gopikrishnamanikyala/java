package gt.app.config;

import dasniko.testcontainers.keycloak.KeycloakContainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.testcontainers.elasticsearch.ElasticsearchContainer;

@Profile("withTestContainer")
@Configuration
@Slf4j
public class DockerContainerConfig {

    static {
        var es = new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:7.7.1");
        es.start();


        var kc = new KeycloakContainer("quay.io/keycloak/keycloak:10.0.2").withRealmImportFile("keycloak/keycloak-export.json");
        kc.start();

        System.setProperty("ELASTICSEARCH_HOSTADDR", es.getHttpHostAddress());
        System.setProperty("KEYCLOAK_PORT", Integer.toString(kc.getHttpPort()));
    }

}