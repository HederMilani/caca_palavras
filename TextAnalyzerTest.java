import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TextAnalyzerTest {

    private final TextAnalyzer analyzer = new TextAnalyzer();
    private static final String TEST_STRING = "No mundo atual, a infraestrutura em nuvem se tornou essencial para o desenvolvimento e implantação de aplicações web. A Virtual Private Server (VPS), ou Servidor Virtual Privado, é uma solução popular que oferece controle, escalabilidade e desempenho para hospedar aplicativos online. Neste artigo, apresentaremos um guia completo sobre como preparar uma VPS para hospedar uma aplicação Spring, permitindo que você execute e disponibilize sua aplicação com facilidade e segurança.\n" +
            "O processo será detalhado, desde a escolha do provedor de nuvem até a configuração do servidor web Nginx para servir a aplicação na web. Utilizaremos como exemplo a plataforma DigitalOcean, no entanto, os procedimentos podem ser adaptados para outras provedoras de nuvem que ofereçam serviços de VPS. Vamos começar preparando a VPS com todos os requisitos necessários para hospedar a sua aplicação Spring. \n" +
            "\n" +
            "Preparando a nossa VPS\n" +
            "\n" +
            "Primeiramente vamos preparar a VPS para que a mesma esteja com todo o ambiente necessário para executar e disponibilizar a nossa aplicação Spring.\n" +
            "Existem diversos provedores de nuvem que disponibilizam um serviço de VPS, nesse artigo vamos utilizar a DigitalOcean, porém, todo o passo a passo de configuração aqui demonstrado pode ser aplicado para outros provedores de nuvem. Pois essencialmente uma VPS nada mais é do que uma máquina virtual.\n" +
            "\n" +
            "Criando um projeto\n" +
            "\n" +
            "Agora vamos criar um Droplet, nome dado pela DigitalOcean ao seu produto de VPS. Para isso acesse a sua conta na DigitalOcean e selecione a opção de criar um novo Droplet.\n" +
            "Na tela de criação de um Droplet, vamos precisar passar algumas configurações. A primeira é que precisamos informar qual a região do Datacenter que irá conter o nosso Droplet.\n" +
            "O ideal é escolher a região geograficamente mais próxima aos usuários que irão utilizar a aplicação.\n" +
            "Logo em seguida precisamos escolher qual a imagem do sistema operacional que vamos utilizar em nosso Droplet.\n" +
            "Para esse artigo vamos utilizar uma máquina Ubuntu 22.04.\n" +
            "Também precisamos informar qual será a configuração de hardware do nosso Droplet. Esse é um ponto muito importante, pois, dependendo das configurações de hardware, seremos cobrados um valor diferente.\n" +
            "Para esse exemplo vamos utilizar uma máquina com uma CPU AMD, com 1 GB de memória e 25 GB de armazenamento em disco. Para essa configuração seremos cobrados o valor de sete dólares por mês. Lembrado que a DigitalOcean só cobra pelo tempo utilizando, ou seja, caso a máquina fique disponível por um único dia, só seremos cobrados o equivalente há um dia de uso e não por um mês completo.\n" +
            "Agora precisamos informar o método de autenticação que iremos utilizar, para facilitar, vamos utilizar uma autenticação com senha.\n" +
            "Conectando ao Droplet via SSH\n" +
            "\n" +
            "Agora que o nosso Droplet está criado, vamos precisar entrar no terminal desse Droplet para podermos executar comandos na nossa VPS. Para isso iremos utilizar o SSH (Secure Shell).\n" +
            "Primeiramente, precisamos do endereço IP que foi gerando para o nosso Droplet, para obter essa informação vá até a página de listagem dos Droplets, página essa para qual formos redirecionados após a criação do Droplet e copie o endereço IP disponibilizado.\n" +
            "Agora que temos o endereço IP do nosso Droplet vamos nos conectar a nossa VPS com o seguinte comando:\n" +
            "ssh root@165.232.148.181\n" +
            "Lembre-se de substituir o endereço IP do comando acima para o endereço IP da sua VPS.\n" +
            "Ao executar o comando acima pela primeira vez será exibida a seguinte mensagem:\n" +
            "The authenticity of host '165.232.148.181 (165.232.148.181)' can't be established.\n" +
            "ED25519 key fingerprint is SHA256:stYZPeU0IekNoljTjsAs8uHQiZFlSrnBhCvYDPisuwY.\n" +
            "This key is not known by any other names\n" +
            "Are you sure you want to continue connecting (yes/no/[fingerprint])?\n" +
            "Basta digitar “yes” e depois dar um enter e logo em seguida digitar a senha que você configurou para o usuário root na criação do seu Droplet e dar um enter novamente.\n" +
            "Configurando um Firewall\n" +
            "Como boa prática de segurança, vamos habilitar um firewall em nosso servidor para garantir que apenas certos serviços possam receber conexões externas.\n" +
            "Para isso vamos utilizar o UFW (Uncomplicated Firewall), que é um serviço de firewall que Já vem disponibilizado no Linux Ubuntu.\n" +
            "Primeiramente vamos configurar o UFW para permitir conexões via SSH, para isso execute o seguinte comando:\n" +
            "ufw allow OpenSSH \n" +
            "E por fim vamos habilitar o nosso firewall com o comando:\n" +
            "ufw enable\n" +
            "Como o firewall está bloqueando atualmente todas as conexões, exceto o SSH, se você instalar e configurar serviços adicionais, precisará ajustar as configurações do firewall para permitir o tráfego.";

    // Count the number of words in a text
    @Test
    public void testWordCount() {
        assertTrue(analyzer.countWords(TEST_STRING) > 500);
        assertEquals(694, analyzer.countWords(TEST_STRING));
    }

    // Count the number of characters in a text
    @Test
    public void testCharacterCount() {
        int characterCount = analyzer.countCharacters(TEST_STRING);
        assertTrue(characterCount > 0);
        assertTrue(characterCount > 1000);
        assertEquals(4618, characterCount);
    }

    // Count the number of characters in a text, excluding spaces
    @Test
    public void testCharacterCountExcludingSpaces() {
        int characterCount = analyzer.countCharactersExcludingSpaces(TEST_STRING);
        assertTrue(characterCount > 0);
        assertTrue(characterCount > 1000);
        assertEquals(3925, characterCount);
    }

    // Count the number of words that have 1 to 5 letters.
    @Test
    public void testCountWordsWithLength() {
        int countWordsWithLength = analyzer.countWordsWithLength(TEST_STRING, 1, 5);
        assertTrue(countWordsWithLength > 0);
        assertTrue(countWordsWithLength > 100);
        assertEquals(410, countWordsWithLength);
    }

    // Count the number of letters "j" in a text
    @Test
    public void testCountOccurrencesOfLetter() {
        int countOccurrencesOfLetter = analyzer.countOccurrencesOfLetter(TEST_STRING, 'j');
        assertTrue(countOccurrencesOfLetter > 0);
        assertEquals(7, countOccurrencesOfLetter);
    }
}
