delete from worker_dep;
delete from worker_role;
delete from worker;

insert into worker(id, lastname, name, password, post) VALUES
    (1, 'qq', 'qq', 'qq', 'qq'),
    (2, 'q1', 'q', 'q', 'q'),
    (3, 'q2', 'q', 'q', 'q'),
    (4, 'q3', 'q', 'q', 'q'),
    (5, 'q4', 'q', 'q', 'q'),
    (6, 'q5', 'q', 'q', 'q'),
    (7, 'q6', 'q', 'q', 'q'),
    (8, 'q7', 'q', 'q', 'q'),
    (9, 'q8', 'q', 'q', 'q'),
    (10, 'q9', 'q', 'q', 'q');

insert into worker_role(worker_id, roles) VALUES
    (1,'GEN_DIR'),
    (2,'DIR'),
    (3,'DIR'),
    (4,'DIR'),
    (5,'LEAD'),
    (6,'LEAD'),
    (7,'LEAD'),
    (8,'WORKER'),
    (9,'WORKER'),
    (10,'WORKER');

insert into worker_dep(worker_id, departments) values
    (1,'GEN_DEP'),
    (2,'WEB_DEP'),
    (3,'FINANCE_DEP'),
    (4,'PERSONAL_DEP'),
    (5,'WEB_DEP'),
    (6,'FINANCE_DEP'),
    (7,'PERSONAL_DEP'),
    (8,'WEB_DEP'),
    (9,'FINANCE_DEP'),
    (10,'PERSONAL_DEP');
