export class Produto {
  id: number; // Correspondente ao @Id e @GeneratedValue(strategy = GenerationType.AUTO)
  nomeProduto: string; // Correspondente ao campo nomeProduto
  quantidade: number; // Correspondente ao campo quantidade
  precoCusto: number; // Correspondente ao campo precoCusto
  precoVenda: number; // Correspondente ao campo precoVenda
  dataEntrada: string; // Correspondente ao campo dataEntrada com formato de data
  dataSaida: string; // Correspondente ao campo dataSaida com formato de data
}
