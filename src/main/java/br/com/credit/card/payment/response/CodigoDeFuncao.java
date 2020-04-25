package br.com.credit.card.payment.response;

import br.com.credit.card.payment.exception.NaoEncontradoException;

public enum CodigoDeFuncao {
    PERMITE_QUE_O_OPERADOR_ESCOLHA_A_FORMA_DE_PAGAMENTO(0),
    CHEQUE(1),
    DEBITO(2),
    CREDITO(3),
    FININVEST(4),
    CARTAO_BENEFICIO(5),
    CREDITO_CENTRALIZADO(6),
    CARTAO_COMBUSTIVEL(7),
    PARCELE_MAIS_REDECARD(8),
    BENEFICIO_REFEICAO_WAPPA(10),
    BENEFICIO_ALIMENTACAO_WAPPA(11),
    CARTAO_INFOCARD(12),
    PAY_PASS(13),
    CARTAO_GIFT(15),
    DEBITO_PARA_PAGAMENTO_DE_CARNE(16),
    TELEMARKETING_TRANSACAO_DE_CARTAO_DIGITAL(100),
    ABRE_MENU_DE_TRANSACAO_GERENCIAL(110),
    TESTE_DE_COMUNICACAO_COM_SITEF(111),
    MENU_RE_IMPRESSAO(112),
    RE_IMPRESSAO_DE_COMPROVANTE_ESPECIFICO(113),
    RE_IMPRESSAO_DO_ULTIMO_COMPROVANTE(114),
    PRE_AUTORIZACAO(115),
    AJUSTE_DE_PRE_AUTORIZACAO(117),
    CAPTURA_DE_PRE_AUTORIZACAO(118),
    CONSULTA_DE_TRANSACOES_PENDENTES_NO_TERMINAL(130),
    CONSULTA_DE_TRANSACOES_PENDENTES_EM_UM_DOCUMENTO_FISCAL_ESPECIFICO(131),
    CONSULTA_BONUS(150),
    CONSULTA_SALDO_CARTAO_PRESENTE(151),
    CONSULTA_SALDO_CARTAO_GIFT(152),
    CONSULTA_CARTAO_EMS(160),
    VENDA_CARTAO_EMS(161),
    CANCELAMENTO_DE_TRANSACAO_DE_DEBITO_OU_CREDITO(200),
    CANCELAMENTO_TELEMARKETING_TRANSACAO_CARTAO_DIGITAL(201),
    CANCELAMENTO_PRE_AUTORIZACAO(202),
    CANCELAMENTO_DA_CAPTURA_DA_PRE_AUTORIZACAO(203),
    CANCELAMENTO_DA_VENDA_COM_CARTAO_DE_CREDITO(210),
    CANCELAMENTO_DA_VENDA_COM_CARTAO_DE_DEBITO(211),
    CANCELAMENTO_DA_VENDA_COM_CARTAO_COMBUSTIVEL(212),
    CANCELAMENTO_DA_VENDA_COM_CARTAO_GIFT(213),
    CANCELAMENTO_DA_CONSULTA_BONUS(250),
    CANCELAMENTO_RECARGA_CARTAO_PRESENTE(251),
    CANCELAMENTO_ACUMULO_DE_PRONTOS_CARTAO_BONUS(253),
    RESGATE_DE_PONTOS_CARTAO_BONUS(254),
    CANCELAMENTO_DE_RESGATE_DE_PRONTO_CARTAO_BONUS(255),
    ACUMULO_DE_PONTOS_CARTAO_BONUS(256);

    public static CodigoDeFuncao findCodigoDeFuncaoByName(String name) {
        for (CodigoDeFuncao value : values()) {
            if (value.name().contains(name))
                return value;
        }
        throw new NaoEncontradoException("Nao pode ser encontrado codigo de funcao com o nome '" + name+"'");
    }

    public static CodigoDeFuncao findCodigoDeFuncaoByCodigo(int codigo) {
        for (CodigoDeFuncao value : values()) {
            if (value.get() == codigo)
                return value;
        }
        throw new NaoEncontradoException("Codigo de funcao '" + codigo + "' desconhecido");
    }


//257 Cancelamento Recarga Cartão Gift
//260 Recarga Cartão Bônus
//262 Recarga Cartão Presente
//264 Recarga Cartão Gift
//265 Ativação Pagamento Vinculado Cartão Gift
//266 Consulta Cartão Gift
//267 Ativação Cartão Gift Sem Pagamento
//268 Ativação Cartão Gift Com Pagamento
//269 Ativação Desvinculada Cartão Gift
//300 Recarga de pré-pago
//301 Recarga de pré-pago desvinculada do pagamento
//302 Recarga de pré-pago sem coleta de valor
//303 Recarga de pré-pago desvinculada do pagamento e sem coleta de valor
//310 Corresponde Bancário (Pagamento de Contas)
//311 Pagamento de Contas com Saque
// 312 Consulta para Pagamento Desvinculado (Genérico)
//313 Pagamento Desvinculado (Genérico)
//314 Recarga Pré Pago HSBC com Saque
//315 Saque para Pagamento
//316 Cancelamento do pagamento desvinculado (genérico)
//317 Consulta Limites do Correspondente Bancário
//318 Recarga Pré Pago Bradesco
//319 Recarga Pré Pago Bradesco desvinculada do pagamento
//320 Recarga Pré Pago HSBC
//321 Recarga Pré Pago HSBC desvinculada do pagamento
//322 Depósito Identificado
//323 Transferência entre Contas
//324 Pague Fácil
//325 Revalidação de Senha INSS
//350 Venda Produto (Sem Valor)
//351 Cancelamento de Venda Produto (Sem Valor)
//400 Vale-Gás
//401 Validação Vale-Gás
//410 Troco Surpresa
//411 Troco Premiado
//412 Cancelamento Troco Premiado
//500 Consulta Detalhada ACSP
//501 Consulta Detalhada Serasa
//502 Consulta Cadastral Infocard
//530 Consulta Fidelize (PBM)
//531 Venda Fidelize (PBM)
//532 Cancelamento Parcial Fidelize (PBM)
//533 Cancelamento Total Fidelize (PBM)
//540 Pré-autorização PharmaSystem
//541 Recuperação de pré-autorização PharmaSystem
//542 Venda PharmaSystem
//543 Cancelamento PharmaSystem
//550 Obtem Autorização PBM
//552 Venda PBM
//553 Cancelamento Parcial PBM
//554 Cancelamento Total PBM
//560 Consulta Telenet/Funcional Card (PBM)
//561 Venda Telenet/Funcional Card (PBM)
//562 Cancelamento Telenet/Funcional Card (PBM)
//563 Pré-autorização Telenet/Funcional Card (PBM)
//564 Consulta cliente Telenet/Funcional Card (PBM)
//570 Consulta EPharma(PBM)
//571 Venda EPharma (PBM)
//572 Cancelamento Parcial EPharma (PBM)
//573 Cancelamento Total EPharma (PBM)
//580 Consulta PrevSaude (PBM)
//581 Venda PrevSaude (PBM)
//582 Cancelamento Parcial PrevSaude (PBM)
//583 Cancelamento Total PrevSaude (PBM)
//590 Consulta Operadoras TrnCentre (PBM)
//591 Consulta Pré Autorização TrnCentre (PBM)
//592 Venda sem Pré Autorização TrnCentre (PBM)
//593 Venda com Pré Autorização TrnCentre (PBM)
//594 Cancelamento TrnCentre (PBM)
//600 Consulta Saldo
//601 Consulta Saldo Cartão de Débito
//602 Consulta Saldo Cartão de Crédito
//605 Consulta Saldo Cartão Combustível
//606 Consulta de Redes Cartão Combustível
//607 Consulta Produtos Cartão Combust
//605 Consulta Saldo Cartão Combustível
//606 Consulta Redes Cartão Combustível
//607 Consulta Produtos Cartão Combustível
//610 Transações SPTrans (Bilhete Único)
//611 Consulta Saldo SPTrans (Bilhete Único)
//612 Recarga SPTrans (Bilhete Único)
//614 Pagamento de Recarga SPTrans (Bilhete Único)
//615 Consulta de Produtos SPTrans (Bilhete Único)
//616 Recarga SPTrans desvinculada de pagamento (Bilhete Único)
//613 Cartão Marisa (Orbital)
//618 Venda Hopi Hari com Consulta de Produtos
//619 Consulta de Produtos Hopi Hari
//620 Venda Hopi Hari sem Consulta de Produtos
//621 Cancelamento Hopi Hari
//625 Venda Voucher com Consulta Forncedores/Produtos
//626 Consulta Forncedores/Produtos Voucher
//627 Venda Voucher sem Consulta Forncedores/Produtos
//628 Cancelamento venda Voucher
//630 Opções de transações NPTC
//631 Consulta Saldo NPTC
//632 Atualização Cartão NPTC
//633 Consulta Produtos Host NPTC
//634 Consulta Produtos PDV NPTC
//635 Cadastra Produtos NPTC
//636 Troca de senha NPTC
//637 Boleto de venda NPTC
//638 Venda NPTC
//639 Cancelamento de venda NPTC
//640 Desbloqueio Cartão Riachuelo
//641 Troca de senha Cartão Riachuelo
//642 Venda Riachuelo
//649 Venda Private Label Softway/Renner
//650 Venda Cartão Bandeira Softway/Renner
//651 Pagamento de Fatura Softway
//652 Desbloqueio de Cartão Softway/Renner
//653 Troca de Senha Cartão Softway/Renner
//654 Consulta de Fatura Cartão Softway/Renner
//655 Venda Pin de Jogos
//656 Venda Pin de Recarga
//657 Saque Crédito Transferência
//660 Menu Saque IBI
//661 Consulta Saque Banco IBI
//662 Saque Banco IBI
//663 Saque GetNet
//664 Cancelamento Saque GetNet
//665 Resgate de Pontos
//667 Emissão de Pontos
//668 Cancelamento da Emissão de Pontos
//669 Carga de Pré Pago
//670 Cancelamento de Carga de Pré Pago
//671 Consulta Saque com Saque Banco IBI
//672 Cancelamento Saque Banco IBI
//673 Venda DrogaRaia
//674 Cancelamento Venda DrogaRaia
//680 Consulta Saldo Pré Pago
//700 Venda Oi Paggo
//701 Cancelamento Oi Paggo
//702 Pagamento de contas
//703 Cancelamento de Pagamento Cartão Benefício
//704 Primeira Compra
//705 Pagamento de Fatura
//740 Consulta Parcelas Crédito Adm
//999 Fechamento
//1000 Voucher Papel


    private final int codigo;

    CodigoDeFuncao(int codigo) {
        this.codigo = codigo;
    }

    public int get() {
        return codigo;
    }
}
