package com.api_cadastro_produtos.controller;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestParam String descricao, 
                                            @RequestParam BigDecimal valor, 
                                            @RequestParam TipoMovimentacao tipo, 
                                            @RequestParam Long produtoId) {
        movimentacaoService.registrarMovimentacao(descricao, valor, tipo, produtoId);
        return ResponseEntity.ok("Movimentação registrada com sucesso!");
    }
}