public class Main {
    public static void main(String[] args) {
        String usersUML = "https://fake-json-api.mock.beeceptor.com/users";
        String todosUML = "https://dummy-json.mock.beeceptor.com/todos";

        try {
            System.out.println("List of users");
            String usersAnswer = API_Example.getRequest(usersUML);
            API_Example.parseUsers(usersAnswer);

            System.out.println("\nList of tasks");
            String todosAnswer = API_Example.getRequest(todosUML);
            API_Example.parseTodos(todosAnswer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
