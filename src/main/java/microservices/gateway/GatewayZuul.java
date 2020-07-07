package microservices.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayZuul {
	public static void main(String args[]) {
		SpringApplication.run(GatewayZuul.class, args);
	}

}
