-- Inserir dados na tabela Banking Extract
INSERT INTO tb_banking_extract (currrent_date, balance_current_date, category_name, description, pendency_amount, bank_account_detailing_id) VALUES ('2023-07-26', null, 'Miscellaneous Expenses', 'rshop-convenienci-26/07', 16.55, 1)
INSERT INTO tb_banking_extract (currrent_date, balance_current_date, category_name, description, pendency_amount, bank_account_detailing_id) VALUES ('2023-07-25', 1523.02, 'Cellphone', 'int claro s.a 443000007', 364.97, 1)
INSERT INTO tb_banking_extract (currrent_date, balance_current_date, category_name, description, pendency_amount, bank_account_detailing_id) VALUES ('2023-07-25', 1523.02, 'Other Transfers', 'int ted d 4ecaf416', 4704.12, 1)
INSERT INTO tb_banking_extract (currrent_date, balance_current_date, category_name, description, pendency_amount, bank_account_detailing_id) VALUES ('2023-07-25', 1523.02, 'Salary', 'remuneracao/salario', 6832.03, 1)
INSERT INTO tb_banking_extract (currrent_date, balance_current_date, category_name, description, pendency_amount, bank_account_detailing_id) VALUES ('2023-07-25', 1523.02, 'Other Transfers', 'pix transf vinicius25/07', 300.00, 1)
INSERT INTO tb_banking_extract (currrent_date, balance_current_date, category_name, description, pendency_amount, bank_account_detailing_id) VALUES ('2023-07-24', 60.08, 'Food And Beverages', 'pix qrs ifoof.com aa22/07', 44.90, 1)
INSERT INTO tb_banking_extract (currrent_date, balance_current_date, category_name, description, pendency_amount, bank_account_detailing_id) VALUES ('2023-07-24', 60.08, 'Fuel', 'rshop auto-posto -23/07', 23.50, 1)
INSERT INTO tb_banking_extract (currrent_date, balance_current_date, category_name, description, pendency_amount, bank_account_detailing_id) VALUES ('2023-07-24', 60.08, 'Insurance', 'pato itau seguros', 8.66, 1)
INSERT INTO tb_banking_extract (currrent_date, balance_current_date, category_name, description, pendency_amount, bank_account_detailing_id) VALUES ('2023-07-24', 60.08, 'Insurance', 'pato itau seguros', 9.32, 1)

-- Inserir dados na tabela State
INSERT INTO tb_state (name, country) VALUES ('São Paulo', 'São Paulo');

-- Inserir dados na tabela City
INSERT INTO tb_city (name, city_area, state_id) VALUES ('Barueri - SP', 'Zona Oeste', 1);

-- Inserir dados na tabela Contact Data
INSERT INTO tb_contact_data(phone, street_or_avenue, email) VALUES ('11-945589975', 'Avenida Aruanã 851 - Apartamento 182 B', 'vinicius.pascucci1@gmail.com')

-- Inserir dados na tabela Bank Account Detailing
INSERT INTO tb_banking_account(full_name_account_holder, number_bank, number_bank_account, cpf_cnpj_account_holder, contact_data_id, bank_account_detailing_id, balance_account, password_or_acces_code) VALUES ('Vinicius Torres Pascucci', 341, 192711, 42155435843, 1, 1, 4500.0, '123456789')

-- Inserir dados na tabela Bank Detailing Account
INSERT INTO tb_bank_card(name, flag_credit_card, type_credit_card, limit_credit_card, bank_detailing_account_id) VALUES('ItauCard MAESTRO Final 7590', 'MASTERCARD', 'Multiplo Debito/Credito', 20900.0, 1)

-- Inserir dados na tabela Account Extract
INSERT INTO tb_account_extract (description_account_extract, transaction_history_id) VALUES ('Extract Account Holder 01 - Vinicius Torres Pasccci', 1);
