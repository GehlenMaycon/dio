/*--------------------------------------
	Quantidade de Pedidos por cliente
----------------------------------------*/
SELECT 
CLI.IDCLIENTE,
CLI.NOME,
COUNT(*) AS QTDPEDIDOS 
FROM PEDIDO PED
JOIN CLIENTE CLI ON CLI.IDCLIENTE = PED.IDCLIENTE
GROUP BY CLI.IDCLIENTE, CLI.NOME;


-- -----------------------------------------------------
-- Relação Produto/Fornecedor, a agregação é para unificar os locais de estoque
-- -----------------------------------------------------
SELECT 
	FORN.NOME AS FORNECEDOR,
    CONCAT(PRO.IDPRODUTO, ' - ',PRO.DESCRICAO) AS PRODUTO,
    SUM(EST.QUANTIDADE)
FROM FORNECEDORESPRODUTO FPRO
JOIN PRODUTO PRO ON PRO.IDPRODUTO = FPRO.IDPRODUTO 
JOIN FORNECEDOR FORN ON FORN.IDFORNECEDOR = FPRO.IDFORNECEDOR
LEFT JOIN ESTOQUE EST ON EST.IDPRODUTO = PRO.IDPRODUTO
GROUP BY 1,2;

-- -----------------------------------------------------
-- Relação Nome fornecedor e nome do produto
-- -----------------------------------------------------
SELECT 
	FORN.NOME AS FORNECEDOR,
    PRO.DESCRICAO AS PRODUTO
FROM FORNECEDORESPRODUTO FPRO
JOIN PRODUTO PRO ON PRO.IDPRODUTO = FPRO.IDPRODUTO 
JOIN FORNECEDOR FORN ON FORN.IDFORNECEDOR = FPRO.IDFORNECEDOR
GROUP BY 1,2;