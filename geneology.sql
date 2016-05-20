--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: relatives; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE relatives (
    id integer NOT NULL,
    relative_name character varying,
    relation character varying,
    user_id integer,
    relation_type_id integer,
    img character varying
);


ALTER TABLE relatives OWNER TO "Guest";

--
-- Name: relatives_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE relatives_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE relatives_id_seq OWNER TO "Guest";

--
-- Name: relatives_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE relatives_id_seq OWNED BY relatives.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE users (
    id integer NOT NULL,
    user_name character varying,
    password character varying,
    tree_exists boolean,
    img character varying
);


ALTER TABLE users OWNER TO "Guest";

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO "Guest";

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY relatives ALTER COLUMN id SET DEFAULT nextval('relatives_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: relatives; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY relatives (id, relative_name, relation, user_id, relation_type_id, img) FROM stdin;
374	Joe	Mother Sibling 1	5	13	https://scontent-ord1-1.xx.fbcdn.net/v/t1.0-9/309866_2182784681739_910538056_n.jpg?oh=08c666b3768a7ba2de7be4ab7ce8db38&oe=57CDC134
375	Glor	Mother Sibling 2	5	14	https://scontent-ord1-1.xx.fbcdn.net/t31.0-8/10869819_10100661639570929_1386119168331931080_o.jpg
376	Kara	Mother Sibling 1 Child 1	5	15	https://scontent-ord1-1.xx.fbcdn.net/t31.0-8/12973113_10207277851202283_646886627743319610_o.jpg
377	Nick	Mother Sibling 1 Child 2	5	16	https://scontent-ord1-1.xx.fbcdn.net/t31.0-8/10872952_10100661636961159_6999824535532519151_o.jpg
379		Mother Sibling 2 Child 2	5	18	\N
380	Jess	Sibling 1	5	19	https://scontent-ord1-1.xx.fbcdn.net/v/t1.0-9/13043706_10154073615257383_2294700599500980944_n.jpg?oh=3b6f06b91ad2bbea2621b5dde44b3a05&oe=57CFC1BB
381	Archie	Sibling 2	5	20	https://scontent-ord1-1.xx.fbcdn.net/v/t1.0-9/12341547_10208125449157732_3593686133573172148_n.jpg?oh=25ca9f81113f7822494c828de4a5933e&oe=57996B7B
378	Aaron	Mother Sibling 2 Child 1	5	17	https://scontent-ord1-1.xx.fbcdn.net/t31.0-8/13131549_10101032121452269_5727490452876914364_o.jpg
373	Angie	Maternal Grandmother	5	12	https://scontent-ord1-1.xx.fbcdn.net/v/t1.0-9/13124512_10209331868357458_6492979740390890283_n.jpg?oh=7b8df4dcb04e9539df99f4c19f7c2538&oe=5799C904
382	D	Father	10	1	\N
383	gdfgs	Paternal Grandfather	10	2	\N
384	ag	Paternal Grandmother	10	3	\N
385	ggafagd	Father Sibling 1	10	4	\N
386		Father Sibling 2	10	5	\N
362	Jeff	Father	5	1	https://scontent-ord1-1.xx.fbcdn.net/t31.0-8/10842157_10152412983736184_2484606595307246598_o.jpg
371	Janice	Mother	5	10	https://scontent-ord1-1.xx.fbcdn.net/v/t1.0-9/1471292_10206608988007151_3714025416226798577_n.jpg?oh=965d6bd810f7e32ae1eb706dd21f1e3f&oe=57D1EFAC
363	Gene	Paternal Grandfather	5	2	https://scontent-ord1-1.xx.fbcdn.net/v/t1.0-9/10422008_10203480498189227_2810439470916293649_n.jpg?oh=b7c205cafe706ac19768f72a8735d706&oe=57D1C904
364	Millie	Paternal Grandmother	5	3	https://scontent-ord1-1.xx.fbcdn.net/v/t1.0-9/10268651_10203225756020832_1023466146548666112_n.jpg?oh=5cbad79678c08eabb599ee6ae9c430c6&oe=57DD5E7D
365	Kim	Father Sibling 1	5	4	https://scontent-ord1-1.xx.fbcdn.net/v/t1.0-9/12803202_10207908749172734_6153662293401660108_n.jpg?oh=dc647968e0d4101ca1f5a80485eb549b&oe=57D66196
366	Jeani	Father Sibling 2	5	5	https://scontent-ord1-1.xx.fbcdn.net/v/t1.0-9/12802720_10207908747452691_3898107089497692608_n.jpg?oh=f9aa15e45c037f579b550e38c31a9f32&oe=57A14DCB
367	Colin	Father Sibling 1 Child 1	5	6	https://scontent-ord1-1.xx.fbcdn.net/v/t1.0-9/10940624_10153029189428514_6504911363331080814_n.jpg?oh=7c35d77a624c7ad6fef651ded6d78c47&oe=57CDACB1
368	Devin	Father Sibling 1 Child 2	5	7	https://scontent-ord1-1.xx.fbcdn.net/t31.0-8/10818515_939177529448726_2992134363110654650_o.jpg
387		Father Sibling 1 Child 1	10	6	\N
388		Father Sibling 1 Child 2	10	7	\N
389		Father Sibling 2 Child 1	10	8	\N
390		Father Sibling 2 Child 2	10	9	\N
391	gd	Mother	10	10	\N
392	fsg	Maternal Grandfather	10	11	\N
393		Maternal Grandmother	10	12	\N
394	df	Mother Sibling 1	10	13	\N
395		Mother Sibling 2	10	14	\N
369	Becky	Father Sibling 2 Child 1	5	8	https://scontent-ord1-1.xx.fbcdn.net/v/t1.0-9/10251888_10205887591136442_8538305139056646978_n.jpg?oh=ec3bc2870d5f7dc3ed646dd41195fd01&oe=57A0BE77
370	Heather	Father Sibling 2 Child 2	5	9	https://scontent-ord1-1.xx.fbcdn.net/t31.0-8/10983136_10205753726094835_3462716199986840462_o.jpg
372	Joe	Maternal Grandfather	5	11	https://scontent-ord1-1.xx.fbcdn.net/t31.0-8/10258459_10203914409244366_5549645930897115248_o.jpg
396		Mother Sibling 1 Child 1	10	15	\N
397		Mother Sibling 1 Child 2	10	16	\N
398		Mother Sibling 2 Child 1	10	17	\N
399		Mother Sibling 2 Child 2	10	18	\N
400		Sibling 1	10	19	\N
401		Sibling 2	10	20	\N
402	adf	Father	11	1	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
403	fadfa	Paternal Grandfather	11	2	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
404	dfadfga	Paternal Grandmother	11	3	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
405		Father Sibling 1	11	4	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
406		Father Sibling 2	11	5	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
407		Father Sibling 1 Child 1	11	6	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
408		Father Sibling 1 Child 2	11	7	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
409		Father Sibling 2 Child 1	11	8	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
410		Father Sibling 2 Child 2	11	9	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
411		Mother	11	10	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
413		Maternal Grandmother	11	12	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
414		Mother Sibling 1	11	13	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
415		Mother Sibling 2	11	14	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
416		Mother Sibling 1 Child 1	11	15	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
417		Mother Sibling 1 Child 2	11	16	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
418		Mother Sibling 2 Child 1	11	17	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
419		Mother Sibling 2 Child 2	11	18	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
420		Sibling 1	11	19	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
421		Sibling 2	11	20	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
412	gadafd	Maternal Grandfather	11	11	https://memecrunch.com/meme/ADWIZ/bruh/image.jpg?w=500&c=1
422	adf	Father	12	1	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
423	afgdg	Paternal Grandfather	12	2	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
424	gagsdg	Paternal Grandmother	12	3	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
425	dfad	Father Sibling 1	12	4	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
426	agdag	Father Sibling 2	12	5	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
427	agga	Father Sibling 1 Child 1	12	6	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
428	sdfsdf	Father Sibling 1 Child 2	12	7	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
429		Father Sibling 2 Child 1	12	8	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
430		Father Sibling 2 Child 2	12	9	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
431	fdfsdf	Mother	12	10	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
432	adfadf	Maternal Grandfather	12	11	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
433	sdgsa	Maternal Grandmother	12	12	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
434	fadv	Mother Sibling 1	12	13	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
435	agafg	Mother Sibling 2	12	14	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
436	ddafd	Mother Sibling 1 Child 1	12	15	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
437	sdfsd	Mother Sibling 1 Child 2	12	16	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
438		Mother Sibling 2 Child 1	12	17	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
439		Mother Sibling 2 Child 2	12	18	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
440		Sibling 1	12	19	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
441		Sibling 2	12	20	https://upload.wikimedia.org/wikipedia/commons/3/33/White_square_with_question_mark.png
\.


--
-- Name: relatives_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('relatives_id_seq', 441, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY users (id, user_name, password, tree_exists, img) FROM stdin;
6	BRUH	dude	\N	\N
7	Bruh	dude	\N	\N
8	dur	dur	\N	\N
9	steve	steve	t	\N
5	Ryan	dirt	t	https://scontent-ord1-1.xx.fbcdn.net/t31.0-8/12622395_10205818020314487_5648798233376633023_o.jpg
10	you	you	t	\N
11	me	me	t	\N
12	ruh	ruh	t	\N
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('users_id_seq', 12, true);


--
-- Name: relatives_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY relatives
    ADD CONSTRAINT relatives_pkey PRIMARY KEY (id);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

