package com.demo.security.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Title: OpenAPIConfig
 * @Author Hannibal
 * @Package com.demo.security.core.config
 * @Date 23/08/2023 18:28
 * @Description: TODO
 */
@Configuration
public class OpenAPIConfig {
    /**
     * @Api → @Tag
     * @ApiIgnore → @Parameter(hidden = true) or @Operation(hidden = true) or @Hidden
     * @ApiImplicitParam → @Parameter
     * @ApiImplicitParams → @Parameters
     * @ApiModel → @Schema
     * @ApiModelProperty(hidden = true) → @Schema(accessMode = READ_ONLY)
     * @ApiModelProperty → @Schema
     * @ApiOperation(value = "foo", notes = "bar") → @Operation(summary = "foo", description = "bar")
     * @ApiParam → @Parameter
     * @ApiResponse(code = 404, message = "foo") → @ApiResponse(responseCode = "404", description = "foo")
     */
    @Value("${server.port}")
    private String port;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();

        devServer.setUrl("localhost:" + port);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("yuewu0527@qq.com");
        contact.setName("Hannibal");
        contact.setUrl("tulips.wiki");


        Info info = new Info()
                .title("OpenAPI Documentation")
                .version("1.0")
                .contact(contact)
                .description("SpringCloud Documentation.")
                .termsOfService("tulips.wiki");

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer));
    }
}
