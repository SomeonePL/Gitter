package gitter.app;


public class Gitter {
    public Gitter() {
    }

    String repository_name;

    public String getRepository_name() {
        return repository_name;
    }

    public void setRepository_name(String repository_name) {
        this.repository_name = repository_name;
    }

    public void recent(){
        Reader finder = new Reader();
        for (int i = 1; i < 11; i++) {
            String url = "https://api.github.com/orgs/allegro/events?page=" + i;
            System.out.println(url);
            String new_repository = finder.read(url);
            if(new_repository != ""){
                this.setRepository_name(new_repository);
                return;
            }
        }


    }
}
