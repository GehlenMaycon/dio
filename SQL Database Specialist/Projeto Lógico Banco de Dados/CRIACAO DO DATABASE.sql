CREATE DATABASE ECOMMERCE;

USE ECOMMERCE;

-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`PRODUTO` (
  IDPRODUTO INT NOT NULL AUTO_INCREMENT,
  DESCRICAO VARCHAR(45) NULL,
  CATEGORIA VARCHAR(45) NULL,
  VALOR FLOAT NULL,
  PRIMARY KEY (IDPRODUTO))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Local`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`LOCAL` (
  IDLOCAL INT NOT NULL AUTO_INCREMENT,
  LOCAL VARCHAR(45) NOT NULL,
  ENDERECO VARCHAR(45) NOT NULL,
  PRIMARY KEY (IDLOCAL))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`CLIENTE` (
  IDCLIENTE INT NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(45) NOT NULL,
  CGC VARCHAR(45) NOT NULL,
  TIPO ENUM('PF', 'PJ') NOT NULL,
  ENDERECO VARCHAR(45) NOT NULL,
  PRIMARY KEY (IDCLIENTE))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Formas de Pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`FORMAPGTO` (
  IDFORMAPGTO INT NOT NULL AUTO_INCREMENT,
  INTERVALOVENCIMENTO INT NOT NULL,
  NROPARCELAS INT NOT NULL,
  DESCRICAO VARCHAR(45) NOT NULL,
  PRIMARY KEY (IDFORMAPGTO))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Frete`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`FRETE` (
  IDFRETE INT NOT NULL AUTO_INCREMENT,
  NRORASTREIO INT NOT NULL,
  STATUS VARCHAR(45) NOT NULL,
  DTENTREGA DATE NULL,
  PRIMARY KEY (IDFRETE))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`PEDIDO` (
  IDPEDIDO INT NOT NULL AUTO_INCREMENT,
  STATUS VARCHAR(45) NOT NULL,
  IDCLIENTE INT NOT NULL,
  IDFORMAPGTO INT NOT NULL,
  DTPEDIDO DATE NOT NULL,
  IDFRETE INT NOT NULL,
  PRIMARY KEY (IDPEDIDO),
  INDEX `fk_Pedido_Cliente_idx` (IDCLIENTE ASC) ,
  INDEX `fk_Pedido_Formapgto_idx` (IDFORMAPGTO ASC),
  INDEX `fk_Pedido_Frete1_idx` (IDFRETE ASC),
  CONSTRAINT `fk_Pedido_Cliente`
    FOREIGN KEY (IDCLIENTE)
    REFERENCES `ECOMMERCE`.`CLIENTE` (IDCLIENTE)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Formapgto`
    FOREIGN KEY (IDFORMAPGTO)
    REFERENCES `ECOMMERCE`.`FORMAPGTO` (IDFORMAPGTO)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Frete1`
    FOREIGN KEY (IDFRETE)
    REFERENCES `ECOMMERCE`.`FRETE` (IDFRETE)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`FORNECEDOR` (
   IDFORNECEDOR INT NOT NULL AUTO_INCREMENT,
   NOME VARCHAR(45) NOT NULL,
   CNPJ VARCHAR(45) NOT NULL,
   PRIMARY KEY (IDFORNECEDOR))
 ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Produtos do Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`PRODUTOSDOPEDIDO` (
  IDPEDIDO INT NOT NULL,
  IDPRODUTO INT NOT NULL,
  QUANTIDADE INT NULL,
  PRIMARY KEY (IDPEDIDO, IDPRODUTO),
  INDEX `fk_Pedido_has_Produto_Produto1_idx` (IDPRODUTO ASC),
  INDEX `fk_Pedido_has_Produto_Pedido1_idx` (IDPEDIDO ASC),
  CONSTRAINT `fk_Pedido_has_Produto_Pedido1`
    FOREIGN KEY (IDPEDIDO)
    REFERENCES `ECOMMERCE`.`PEDIDO` (IDPEDIDO)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_has_Produto_Produto1`
    FOREIGN KEY (IDPRODUTO)
    REFERENCES `ECOMMERCE`.`Produto` (IDPRODUTO)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Terceiro - Vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`TERCEIRO` (
  IDTERCEIRO INT NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(45) NOT NULL,
  CGC VARCHAR(45) NOT NULL,
  PRIMARY KEY (IDTERCEIRO),
  UNIQUE INDEX `CGC_UNIQUE` (CGC ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Produto possui Fornecedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`FORNECEDORESPRODUTO` (
  IDPRODUTO INT NOT NULL,
  IDFORNECEDOR INT NOT NULL,
  PRIMARY KEY (IDPRODUTO, IDFORNECEDOR),
  INDEX `fk_Produto_has_Fornecedor_Fornecedor1_idx` (IDFORNECEDOR ASC),
  INDEX `fk_Produto_has_Fornecedor_Produto1_idx` (IDPRODUTO ASC),
  CONSTRAINT `fk_Produto_has_Fornecedor_Produto1`
    FOREIGN KEY (IDPRODUTO)
    REFERENCES `ECOMMERCE`.`PRODUTO` (IDPRODUTO)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_has_Fornecedor_Fornecedor1`
    FOREIGN KEY (IDFORNECEDOR)
    REFERENCES `ECOMMERCE`.`Fornecedor` (IDFORNECEDOR)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`ESTOQUE` (
  IDLOCAL INT NOT NULL,
  IDPRODUTO INT NOT NULL,
  QUANTIDADE INT NULL,
  PRIMARY KEY (IDLOCAL, IDPRODUTO),
  INDEX `fk_Local_has_Produto_Produto1_idx` (IDPRODUTO ASC),
  INDEX `fk_Local_has_Produto_Local1_idx` (IDLOCAL ASC),
  CONSTRAINT `fk_Local_has_Produto_Local1`
    FOREIGN KEY (IDLOCAL)
    REFERENCES `ECOMMERCE`.`LOCAL` (IDLOCAL)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Local_has_Produto_Produto1`
    FOREIGN KEY (IDPRODUTO)
    REFERENCES `ECOMMERCE`.`Produto` (IDPRODUTO)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ECOMMERCE`.`Vendedores do produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`VENDPROD` (
  IDPRODUTO INT NOT NULL,
  IDTERCEIRO INT NOT NULL,
  PRIMARY KEY (IDPRODUTO, IDTERCEIRO),
  INDEX `fk_Produto_has_Terceiro - Vendedor_Terceiro - Vendedor1_idx` (IDTERCEIRO ASC),
  INDEX `fk_Produto_has_Terceiro - Vendedor_Produto1_idx` (IDPRODUTO ASC),
  CONSTRAINT `fk_Produto_has_Terceiro - Vendedor_Produto1`
    FOREIGN KEY (IDPRODUTO)
    REFERENCES `ECOMMERCE`.`PRODUTO` (IDPRODUTO)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_has_Terceiro`
    FOREIGN KEY (IDTERCEIRO)
    REFERENCES `ECOMMERCE`.`TERCEIRO` (IDTERCEIRO)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ECOMMERCE`.`CARTOES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ECOMMERCE`.`CARTOES` (
  IDCARTAO INT NOT NULL AUTO_INCREMENT,
  BANDEIRA VARCHAR(45) NOT NULL,
  TITULAR VARCHAR(45) NOT NULL,
  NROCARTAO INT NOT NULL,
  DTVENCIMENTO DATE NOT NULL,
  IDCLIENTE INT NOT NULL,
  PRIMARY KEY (IDCARTAO, IDCLIENTE),
  INDEX `fk_CARTOES_Cliente1_idx` (IDCLIENTE ASC),
  CONSTRAINT `fk_CARTOES_Cliente1`
    FOREIGN KEY (IDCLIENTE)
    REFERENCES `ECOMMERCE`.`Cliente` (IDCLIENTE)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
