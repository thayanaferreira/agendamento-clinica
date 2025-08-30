// Classe responsável por carregar dados iniciais no banco de dados ao iniciar a aplicação.
// Utilizada principalmente para fins de teste. Testando o persistencia de dados antes da implementação do Service.
// Executa automaticamente ao subir a aplicação por implementar CommandLineRunner.
package com.example.agendamentoclinicathay.ini;

import com.example.agendamentoclinicathay.model.Cliente;
import com.example.agendamentoclinicathay.model.Pessoa;
import com.example.agendamentoclinicathay.repository.ClienteRepository;
import com.example.agendamentoclinicathay.repository.PessoaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {

    private final PessoaRepository pessoaRepository;
    private final ClienteRepository clienteRepository;

    public DataLoader(PessoaRepository pessoaRepository, ClienteRepository clienteRepository) {
        this.pessoaRepository = pessoaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        clienteRepository.deleteAll();
        pessoaRepository.deleteAll();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria");
        pessoa.setCpf("12345678900");
        pessoa.setTelefone("61999999999");
        pessoa.setEmail("maria@example.com");
        pessoa.setDataNascimento(LocalDate.of(1990, 1, 1));
        //Pessoa pessoaSalva = pessoaRepository.save(pessoa);
                // se salvar pessoa aqui, dá erro quando chegar no save(cliente), pois id pessoa já vai existir em pessoa,
                // e o Hibernate precisa persistir o id (igual) nas duas tabelas ao mesmo tempo. Do contrário o Hibernate
                // vai ficar reclamando que o objeto pessoa está fora do contexto de persistência atual.
                // o erro que aparece "detached entity passed to persist: com.example.agendamentoclinicathay.model.Pessoa"
                // detached == separado (nesse caso: fora)

        Cliente cliente = new Cliente();
        cliente.setPessoa(pessoa);
        cliente.setConvenio("Unimed");
        cliente.setNumeroCarteira("ABC123");
        cliente.setValidadeCarteira(LocalDate.of(2025, 12, 31));
        clienteRepository.save(cliente);
    }
}

