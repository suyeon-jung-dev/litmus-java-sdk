import io.litmuschaos.LitmusClient;
import io.litmuschaos.request.ListProjectRequest;
import io.litmuschaos.response.ListProjectsResponse;

import java.io.IOException;


public class Example {

    private static final String hostUrl = "http://localhost:3000";
    private static final String username = "admin";
    private static final String password = "Litmus1234!";

    public static void main(String[] args) throws IOException {

        try (LitmusClient litmusClient = new LitmusClient(hostUrl, username, password)) {
            ListProjectRequest request = new ListProjectRequest.Builder()
                    .page(0)
                    .limit(10)
                    .sortField("name")
                    .createdByMe(true)
                    .build();
            ListProjectsResponse response = litmusClient.listProjects(request);

            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
