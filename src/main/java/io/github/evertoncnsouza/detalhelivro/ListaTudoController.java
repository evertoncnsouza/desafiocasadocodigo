/*ackage io.github.evertoncnsouza.detalhelivro;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;

@RequestMapping("api/lista-tudo")
@RestController
public class ListaTudoController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    public HashMap<String, Object> list() {
     /*   List autors = manager.createQuery("select a from Autor a").getResultList();

        HashMap<String, Object> resultado = new HashMap<>();
        resultado.put("autores", autors.toString());

        List categorias = manager.createQuery("select c from Categoria c").getResultList();
        resultado.put("categorias", categorias.toString());

        List cupons = manager.createQuery("select c from Cupom c").getResultList();
        resultado.put("cupons", cupons.toString())

        List livros = manager.createQuery("select c from Livro c").getResultList();
        resultado.put("livros", livros.toString());
        return resultado;
    }
*/
