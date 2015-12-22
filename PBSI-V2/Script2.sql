CREATE USER proxibanque identified by proxipass;
grant resource, create sequence, create session, connect to proxibanque;
connect proxibanque/proxipass;