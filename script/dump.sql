--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1 (Debian 16.1-1.pgdg120+1)
-- Dumped by pg_dump version 16.1 (Debian 16.1-1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: administrateur; Type: TABLE; Schema: public; Owner: your_username
--

CREATE TABLE public.administrateur (
    idadministrateur character varying(20) NOT NULL,
    nom character varying(200) NOT NULL,
    prenom character varying(200) NOT NULL,
    email character varying(200) NOT NULL,
    motdepasse character varying(200) NOT NULL
);


ALTER TABLE public.administrateur OWNER TO your_username;

--
-- Name: annonce; Type: TABLE; Schema: public; Owner: your_username
--

CREATE TABLE public.annonce (
    id_annonce character varying(20) NOT NULL,
    annee character varying(10),
    kilometrage double precision,
    date_annonce timestamp without time zone DEFAULT now(),
    description character varying(200),
    etat integer,
    id_utilisateur character varying(20)
);


ALTER TABLE public.annonce OWNER TO your_username;

--
-- Name: axe_details; Type: TABLE; Schema: public; Owner: your_username
--

CREATE TABLE public.axe_details (
    id_axe character varying(20) NOT NULL,
    nom character varying(200)
);


ALTER TABLE public.axe_details OWNER TO your_username;

--
-- Name: axe_possible_values; Type: TABLE; Schema: public; Owner: your_username
--

CREATE TABLE public.axe_possible_values (
    id_axe_possible_values character varying(20) NOT NULL,
    id_modele character varying(20),
    id_axe character varying(20),
    value character varying(200),
    valeur_numerique integer,
    id_value integer
);


ALTER TABLE public.axe_possible_values OWNER TO your_username;

--
-- Name: axe_values; Type: TABLE; Schema: public; Owner: your_username
--

CREATE TABLE public.axe_values (
    id_value integer NOT NULL,
    label character varying(20),
    id_axe character varying(20)
);


ALTER TABLE public.axe_values OWNER TO your_username;

--
-- Name: axe_values_id_value_seq; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.axe_values_id_value_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.axe_values_id_value_seq OWNER TO your_username;

--
-- Name: axe_values_id_value_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: your_username
--

ALTER SEQUENCE public.axe_values_id_value_seq OWNED BY public.axe_values.id_value;


--
-- Name: details_modele; Type: TABLE; Schema: public; Owner: your_username
--

CREATE TABLE public.details_modele (
    id_modele character varying(20),
    id_axe character varying(20),
    value character varying(200),
    id_annonce character varying(20),
    id_details_model character varying(20) NOT NULL
);


ALTER TABLE public.details_modele OWNER TO your_username;

--
-- Name: details_modele_id_details_model_seq; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.details_modele_id_details_model_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.details_modele_id_details_model_seq OWNER TO your_username;

--
-- Name: historique_modification_annonce; Type: TABLE; Schema: public; Owner: your_username
--

CREATE TABLE public.historique_modification_annonce (
    id_annonce character varying(20),
    id_utilisateur character varying(20)
);


ALTER TABLE public.historique_modification_annonce OWNER TO your_username;

--
-- Name: marque; Type: TABLE; Schema: public; Owner: your_username
--

CREATE TABLE public.marque (
    id_marque character varying(20) NOT NULL,
    nom character varying(200)
);


ALTER TABLE public.marque OWNER TO your_username;

--
-- Name: modele; Type: TABLE; Schema: public; Owner: your_username
--

CREATE TABLE public.modele (
    id_modele character varying(20) NOT NULL,
    nom character varying(200),
    id_marque character varying(20)
);


ALTER TABLE public.modele OWNER TO your_username;

--
-- Name: photo; Type: TABLE; Schema: public; Owner: your_username
--

CREATE TABLE public.photo (
    id_photo integer NOT NULL,
    text character varying,
    id_annonce character varying(20)
);


ALTER TABLE public.photo OWNER TO your_username;

--
-- Name: photo_id_photo_seq; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.photo_id_photo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.photo_id_photo_seq OWNER TO your_username;

--
-- Name: photo_id_photo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: your_username
--

ALTER SEQUENCE public.photo_id_photo_seq OWNED BY public.photo.id_photo;


--
-- Name: seq_administrateur; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.seq_administrateur
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_administrateur OWNER TO your_username;

--
-- Name: seq_annonce; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.seq_annonce
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_annonce OWNER TO your_username;

--
-- Name: seq_axe_details; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.seq_axe_details
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_axe_details OWNER TO your_username;

--
-- Name: seq_axe_possible_values; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.seq_axe_possible_values
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_axe_possible_values OWNER TO your_username;

--
-- Name: seq_details_modele; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.seq_details_modele
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_details_modele OWNER TO your_username;

--
-- Name: seq_historique; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.seq_historique
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_historique OWNER TO your_username;

--
-- Name: seq_marque; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.seq_marque
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_marque OWNER TO your_username;

--
-- Name: seq_modele; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.seq_modele
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_modele OWNER TO your_username;

--
-- Name: seq_utilisateur; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.seq_utilisateur
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.seq_utilisateur OWNER TO your_username;

--
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: your_username
--

CREATE TABLE public.utilisateur (
    id_utilisateur character varying(20) NOT NULL,
    nom character varying(200),
    prenom character varying(200),
    date_naissance date,
    email character varying(200),
    mot_de_passe character varying(200)
);


ALTER TABLE public.utilisateur OWNER TO your_username;

--
-- Name: axe_values id_value; Type: DEFAULT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.axe_values ALTER COLUMN id_value SET DEFAULT nextval('public.axe_values_id_value_seq'::regclass);


--
-- Name: photo id_photo; Type: DEFAULT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.photo ALTER COLUMN id_photo SET DEFAULT nextval('public.photo_id_photo_seq'::regclass);


--
-- Data for Name: administrateur; Type: TABLE DATA; Schema: public; Owner: your_username
--

COPY public.administrateur (idadministrateur, nom, prenom, email, motdepasse) FROM stdin;
AD00002	fabien	abie	fab@g.com	1234
AD00022	dsq	mlfkd	fai@fd.dd	dfjs
AD00023	fabien	fabien	test@gmail.com	test
\.


--
-- Data for Name: annonce; Type: TABLE DATA; Schema: public; Owner: your_username
--

COPY public.annonce (id_annonce, annee, kilometrage, date_annonce, description, etat, id_utilisateur) FROM stdin;
\.


--
-- Data for Name: axe_details; Type: TABLE DATA; Schema: public; Owner: your_username
--

COPY public.axe_details (id_axe, nom) FROM stdin;
AX0001	Puissance moteur
AX0002	Carrosserie
AX0003	Carburant
AX0004	Vitesse
AX0005	Portière
AX0006	Version
AX0007	Type de motorisation
AX0008	Couleur
AXE00004	\N
AXE00005	\N
\.


--
-- Data for Name: axe_possible_values; Type: TABLE DATA; Schema: public; Owner: your_username
--

COPY public.axe_possible_values (id_axe_possible_values, id_modele, id_axe, value, valeur_numerique, id_value) FROM stdin;
AXV027	MD0002	AX0003	Diesel	1	9
AXV042	MD0003	AX0003	Diesel	2	9
AXV012	MD0001	AX0003	Diesel	2	9
AXV040	MD0003	AX0002	Convertible	3	8
AXV047	MD0003	AX0006	Standard	1	15
APV00017	MD00003	AX0001	10-20	1	1
APV00018	MD00003	AX0002	Coupé	1	7
APV00019	MD00003	AX0003	Essence	1	10
APV00020	MD00003	AX0004	60+	1	11
APV00021	MD00003	AX0005	4 portes	1	13
APV00022	MD00003	AX0006	Standart	1	15
AXV017	MD0001	AX0006	Standard	1	15
AXV051	MD0003	AX0007	Automatique	2	17
AXV050	MD0003	AX0007	Manuelle	2	18
AXV039	MD0003	AX0002	Convertible	2	8
AXV009	MD0001	AX0002	Convertible	2	8
AXV008	MD0001	AX0002	Coupé	1	7
AXV020	MD0001	AX0007	Manuelle	2	18
AXV045	MD0003	AX0005	4 portes	3	13
AXV031	MD0002	AX0005	4 portes	4	13
AXV023	MD0002	AX0002	Coupé	1	7
AXV036	MD0003	AX0001	70-80	1	5
AXV030	MD0002	AX0005	5 portes	5	14
AXV007	MD0001	AX0001	70-80	2	5
AXV010	MD0001	AX0002	Coupé	3	7
AXV018	MD0001	AX0006	Standard	2	15
AXV038	MD0003	AX0002	Coupé	1	7
AXV021	MD0002	AX0001	80-	1	6
APV00023	MD00003	AX0007	Automatique	1	17
APV00024	MD00003	AX0008	Rouge	1	19
APV00025	MD00004	AX0001	10-20	1	1
APV00026	MD00004	AX0001	20-30	1	2
APV00027	MD00004	AX0001	80-	1	6
AXV013	MD0001	AX0004	100+	1	12
AXV037	MD0003	AX0001	80-	2	6
AXV043	MD0003	AX0004	100+	1	12
APV00028	MD00004	AX0002	Coupé	1	7
APV00029	MD00004	AX0002	Convertible	1	8
APV00030	MD00004	AX0003	Diesel	1	9
AXV029	MD0002	AX0004	100+	2	12
APV00031	MD00004	AX0003	Essence	1	10
APV00032	MD00004	AX0004	60+	1	11
APV00033	MD00004	AX0004	100+	1	12
APV00034	MD00004	AX0005	5 portes	1	14
APV00035	MD00004	AX0006	Standart	1	15
AXV022	MD0002	AX0001	20-30	2	2
AXV035	MD0002	AX0007	Manuelle	1	18
AXV006	MD0001	AX0001	10-20	1	1
APV00036	MD00004	AX0006	Luxe	1	16
APV00037	MD00004	AX0007	Automatique	1	17
APV00038	MD00004	AX0008	Rouge	1	19
APV00039	MD00004	AX0008	Gris	1	21
APV00040	MD00006	AX0001	10-20	1	1
APV00041	MD00006	AX0001	20-30	1	2
APV00042	MD00006	AX0001	30-40	1	3
APV00043	MD00006	AX0001	50-60	1	4
APV00044	MD00006	AX0001	70-80	1	5
APV00045	MD00006	AX0001	80-	1	6
APV00046	MD00006	AX0002	Coupé	1	7
APV00047	MD00006	AX0002	Convertible	1	8
APV00048	MD00006	AX0003	Diesel	1	9
APV00049	MD00006	AX0003	Essence	1	10
APV00050	MD00006	AX0004	60+	1	11
APV00051	MD00006	AX0004	100+	1	12
APV00052	MD00006	AX0005	4 portes	1	13
APV00053	MD00006	AX0005	5 portes	1	14
APV00054	MD00006	AX0006	Standart	1	15
APV00055	MD00006	AX0006	Luxe	1	16
APV00056	MD00006	AX0007	Automatique	1	17
APV00057	MD00006	AX0007	Manuelle	1	18
APV00058	MD00006	AX0008	Rouge	1	19
APV00059	MD00006	AX0008	Bleau	1	20
APV00060	MD00006	AX0008	Gris	1	21
APV00061	MD00006	AX0008	Violet	1	22
APV00062	MD00006	AX0008	Jaune	1	23
\.


--
-- Data for Name: axe_values; Type: TABLE DATA; Schema: public; Owner: your_username
--

COPY public.axe_values (id_value, label, id_axe) FROM stdin;
1	10-20	AX0001
2	20-30	AX0001
3	30-40	AX0001
4	50-60	AX0001
5	70-80	AX0001
6	80-	AX0001
7	Coupé	AX0002
8	Convertible	AX0002
9	Diesel	AX0003
10	Essence	AX0003
11	60+	AX0004
12	100+	AX0004
13	4 portes	AX0005
14	5 portes	AX0005
15	Standart	AX0006
16	Luxe	AX0006
17	Automatique	AX0007
18	Manuelle	AX0007
19	Rouge	AX0008
20	Bleau	AX0008
21	Gris	AX0008
22	Violet	AX0008
23	Jaune	AX0008
30	5	AXE00004
31	6	AXE00004
32	8	AXE00004
33	3	AXE00004
34	32	AXE00004
35	27	AXE00004
36	5	AXE00005
37	6	AXE00005
38	8	AXE00005
39	3	AXE00005
40	32	AXE00005
41	27	AXE00005
\.


--
-- Data for Name: details_modele; Type: TABLE DATA; Schema: public; Owner: your_username
--

COPY public.details_modele (id_modele, id_axe, value, id_annonce, id_details_model) FROM stdin;
\.


--
-- Data for Name: historique_modification_annonce; Type: TABLE DATA; Schema: public; Owner: your_username
--

COPY public.historique_modification_annonce (id_annonce, id_utilisateur) FROM stdin;
\.


--
-- Data for Name: marque; Type: TABLE DATA; Schema: public; Owner: your_username
--

COPY public.marque (id_marque, nom) FROM stdin;
MQ001	Toyota
MQ002	Mercedes
MRQ00001	fabien
MRQ00002	Renault
MRQ00003	Ferrari
\.


--
-- Data for Name: modele; Type: TABLE DATA; Schema: public; Owner: your_username
--

COPY public.modele (id_modele, nom, id_marque) FROM stdin;
MD0001	Yaris	MQ001
MD0002	Hilux	MQ001
MD0003	Sprinter	MQ002
MD00003	Fabien	MQ001
MD00004	TTT	MQ002
MD00005	msdqsl	MRQ00001
MD00006	sqdq	MRQ00002
\.


--
-- Data for Name: photo; Type: TABLE DATA; Schema: public; Owner: your_username
--

COPY public.photo (id_photo, text, id_annonce) FROM stdin;
\.


--
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: your_username
--

COPY public.utilisateur (id_utilisateur, nom, prenom, date_naissance, email, mot_de_passe) FROM stdin;
USR0001	Rakoto	Fabien	2000-01-17	fabien@gmail.com	fabien
USR00001	vaovao	vaovao	2001-11-01	vaovao@gmail.com	vaovao
USR00002	vaovao	vaovao	2001-11-01	vaovao2@gmail.com	vaovao
USR00003	vaovao	vaovao	2001-11-01	vaovao2izyeh@gmail.com	vaovao
USR00004	jj	jj	2024-01-25	o@o.v	  
\.


--
-- Name: axe_values_id_value_seq; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.axe_values_id_value_seq', 41, true);


--
-- Name: details_modele_id_details_model_seq; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.details_modele_id_details_model_seq', 1, false);


--
-- Name: photo_id_photo_seq; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.photo_id_photo_seq', 41, true);


--
-- Name: seq_administrateur; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.seq_administrateur', 33, true);


--
-- Name: seq_annonce; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.seq_annonce', 53, true);


--
-- Name: seq_axe_details; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.seq_axe_details', 5, true);


--
-- Name: seq_axe_possible_values; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.seq_axe_possible_values', 62, true);


--
-- Name: seq_details_modele; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.seq_details_modele', 115, true);


--
-- Name: seq_historique; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.seq_historique', 1, false);


--
-- Name: seq_marque; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.seq_marque', 3, true);


--
-- Name: seq_modele; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.seq_modele', 6, true);


--
-- Name: seq_utilisateur; Type: SEQUENCE SET; Schema: public; Owner: your_username
--

SELECT pg_catalog.setval('public.seq_utilisateur', 4, true);


--
-- Name: administrateur adminitrateur_email_key; Type: CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.administrateur
    ADD CONSTRAINT adminitrateur_email_key UNIQUE (email);


--
-- Name: administrateur adminitrateur_pkey; Type: CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.administrateur
    ADD CONSTRAINT adminitrateur_pkey PRIMARY KEY (idadministrateur);


--
-- Name: annonce annonce_pkey; Type: CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.annonce
    ADD CONSTRAINT annonce_pkey PRIMARY KEY (id_annonce);


--
-- Name: axe_details axe_details_pkey; Type: CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.axe_details
    ADD CONSTRAINT axe_details_pkey PRIMARY KEY (id_axe);


--
-- Name: axe_possible_values axe_possible_values_pkey; Type: CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.axe_possible_values
    ADD CONSTRAINT axe_possible_values_pkey PRIMARY KEY (id_axe_possible_values);


--
-- Name: axe_values axe_values_pkey; Type: CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.axe_values
    ADD CONSTRAINT axe_values_pkey PRIMARY KEY (id_value);


--
-- Name: details_modele details_modele_pkey; Type: CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.details_modele
    ADD CONSTRAINT details_modele_pkey PRIMARY KEY (id_details_model);


--
-- Name: marque marque_pkey; Type: CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.marque
    ADD CONSTRAINT marque_pkey PRIMARY KEY (id_marque);


--
-- Name: modele modele_pkey; Type: CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.modele
    ADD CONSTRAINT modele_pkey PRIMARY KEY (id_modele);


--
-- Name: photo photo_pkey; Type: CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photo_pkey PRIMARY KEY (id_photo);


--
-- Name: utilisateur utilisateur_pkey; Type: CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pkey PRIMARY KEY (id_utilisateur);


--
-- Name: annonce annonce_id_utilisateur_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.annonce
    ADD CONSTRAINT annonce_id_utilisateur_fkey FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id_utilisateur);


--
-- Name: axe_possible_values axe_possible_values_id_axe_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.axe_possible_values
    ADD CONSTRAINT axe_possible_values_id_axe_fkey FOREIGN KEY (id_axe) REFERENCES public.axe_details(id_axe);


--
-- Name: axe_possible_values axe_possible_values_id_modele_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.axe_possible_values
    ADD CONSTRAINT axe_possible_values_id_modele_fkey FOREIGN KEY (id_modele) REFERENCES public.modele(id_modele);


--
-- Name: axe_possible_values axe_possible_values_id_value_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.axe_possible_values
    ADD CONSTRAINT axe_possible_values_id_value_fkey FOREIGN KEY (id_value) REFERENCES public.axe_values(id_value);


--
-- Name: axe_values axe_values_id_axe_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.axe_values
    ADD CONSTRAINT axe_values_id_axe_fkey FOREIGN KEY (id_axe) REFERENCES public.axe_details(id_axe);


--
-- Name: details_modele details_modele_id_annonce_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.details_modele
    ADD CONSTRAINT details_modele_id_annonce_fkey FOREIGN KEY (id_annonce) REFERENCES public.annonce(id_annonce);


--
-- Name: details_modele details_modele_id_axe_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.details_modele
    ADD CONSTRAINT details_modele_id_axe_fkey FOREIGN KEY (id_axe) REFERENCES public.axe_details(id_axe);


--
-- Name: details_modele details_modele_id_modele_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.details_modele
    ADD CONSTRAINT details_modele_id_modele_fkey FOREIGN KEY (id_modele) REFERENCES public.modele(id_modele);


--
-- Name: historique_modification_annonce historique_modification_annonce_id_annonce_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.historique_modification_annonce
    ADD CONSTRAINT historique_modification_annonce_id_annonce_fkey FOREIGN KEY (id_annonce) REFERENCES public.annonce(id_annonce);


--
-- Name: historique_modification_annonce historique_modification_annonce_id_utilisateur_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.historique_modification_annonce
    ADD CONSTRAINT historique_modification_annonce_id_utilisateur_fkey FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id_utilisateur);


--
-- Name: modele modele_id_marque_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.modele
    ADD CONSTRAINT modele_id_marque_fkey FOREIGN KEY (id_marque) REFERENCES public.marque(id_marque);


--
-- Name: photo photo_id_annonce_fkey; Type: FK CONSTRAINT; Schema: public; Owner: your_username
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photo_id_annonce_fkey FOREIGN KEY (id_annonce) REFERENCES public.annonce(id_annonce);


--
-- PostgreSQL database dump complete
--

