package mx.ivai;

import static spark.Spark.*;

public class CorsMiddleware {

    public static void enableCORS() {
        // Permitir peticiones desde cualquier origen
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*"); // Permitir todos los orígenes
            response.header("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Expose-Headers", "Authorization");
        });
    }
}
