package gitter.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GitterTester {
    @Test
    public void WrongURL() {
        Reader r = new Reader();
        Assertions.assertEquals(r.read("Tottaly not an URL"),"ERROR! Unable to manage URL connection or to get response!");
    }

    @Test
    public void NullURl() {
        Reader r = new Reader();
        Assertions.assertEquals(r.read(null),"ERROR! Unable to manage URL connection or to get response!");
    }

    @Test
    public void GitterGetter() throws IOException {
        Gitter g = new Gitter();
        Assertions.assertEquals(g.getRepository_name(),null);
    }

    @Test
    public void GitterSetter() throws IOException {
        Gitter g = new Gitter();
        g.setRepository_name("New repository name");
        Assertions.assertEquals(g.getRepository_name(),"New repository name");
    }

    @Test
    public void GitterRecent() throws IOException {
        Gitter g = new Gitter();
        g.recent();
        String repo_name = g.getRepository_name();
        String [] allegro = repo_name.split("/");
        Assertions.assertEquals(allegro[0],"allegro");
    }

    @Test
    public void TestGitController() throws IOException{
        GitController gc = new GitController();
        Gitter g = gc.recent();

        String repo_name = g.getRepository_name();
        String [] allegro = repo_name.split("/");
        Assertions.assertEquals(allegro[0],"allegro");
    }
}