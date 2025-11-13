package tn.esprit._4twin6.inesmanai.tpcafe_ines_manai.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI cafeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("☕ TPCafé REST API — by Inès Manai")
                        .description(
                                "<div style='font-family:Segoe UI, sans-serif; line-height:1.6;'>" +
                                        "<h2 style='background: linear-gradient(90deg, #a36ff0, #8357c5); " +
                                        "-webkit-background-clip: text; -webkit-text-fill-color: transparent;'>" +
                                        "💜 Bienvenue sur <b>TPCafé API</b></h2>" +
                                        "<p style='color:#555; font-size:15px;'>" +
                                        "Cette API a été conçue pour la gestion complète et intelligente d’un café moderne. " +
                                        "Elle inclut plusieurs modules interconnectés afin d’assurer une gestion fluide et efficace." +
                                        "</p>" +
                                        "<ul style='margin-left:15px; font-size:15px;'>" +
                                        "<li>🍰 <b>Articles</b> — gestion du menu et du stock</li>" +
                                        "<li>📦 <b>Commandes</b> — suivi des ventes et historique</li>" +
                                        "<li>🏠 <b>Adresses</b> — gestion des localisations clients</li>" +
                                        "<li>🎁 <b>Promotions</b> — offres spéciales dynamiques</li>" +
                                        "<li>💳 <b>Cartes de fidélité</b> — points et récompenses automatiques</li>" +
                                        "</ul>" +
                                        "<hr style='border:none; border-top:1px solid #ddd; margin:20px 0;'>" +
                                        "<div style='font-size:13px; color:#555;'>" +
                                        "<p>🧠 Développée avec <b>Spring Boot 3</b> + <b>Swagger UI</b></p>" +
                                        "<p>👩‍💻 Réalisé par " +
                                        "<a href='https://www.linkedin.com/in/manai-inès-658149288' " +
                                        "style='color:#7b3fe4; text-decoration:none; font-weight:bold;'>Inès Manai</a></p>" +
                                        "</div></div>"
                        )
                        .contact(new Contact()
                                .name("Inès Manai")
                                .email("ines.manai@esprit.tn")
                                .url("https://www.linkedin.com/in/manai-inès-658149288")
                        )
                        .license(new License()
                                .name("📘 Licence — Projet universitaire ESPRIT")
                                .url("https://esprit.tn/")
                        )
                        .version("1.0.0")
                )
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8088/TPCafe")
                                .description("🧪 Serveur Local — Développement"),
                        new Server()
                                .url("https://api.tpcafe.tn")
                                .description("🚀 Serveur Distant — Production")
                ))
                .externalDocs(new ExternalDocumentation()
                        .description("📂 Voir le code source sur GitHub")
                        .url("https://github.com/ines55-ai")
                );
    }
}
