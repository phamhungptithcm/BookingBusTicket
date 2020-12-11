--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0
-- Dumped by pg_dump version 13.0

-- Started on 2020-12-04 23:49:26

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

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3114 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 204 (class 1259 OID 42623)
-- Name: bus_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bus_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bus_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 42625)
-- Name: bus; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bus (
    bus_id integer DEFAULT nextval('public.bus_seq'::regclass) NOT NULL,
    bus_name character varying(50) NOT NULL,
    num_seat integer DEFAULT 20,
    bus_license_plate character varying(50),
    last_update timestamp(0) without time zone DEFAULT now()
);


ALTER TABLE public.bus OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 42691)
-- Name: orders_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orders_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_seq OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 42693)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    order_id integer DEFAULT nextval('public.orders_seq'::regclass) NOT NULL,
    amount double precision DEFAULT 0.0,
    order_date timestamp(0) without time zone DEFAULT now(),
    order_status_id integer DEFAULT 1,
    user_id integer DEFAULT 0,
    last_update timestamp(0) without time zone DEFAULT now(),
    note character varying(100)
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 42682)
-- Name: orderstatuses_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orderstatuses_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orderstatuses_seq OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 42684)
-- Name: orderstatuses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orderstatuses (
    id integer DEFAULT nextval('public.orderstatuses_seq'::regclass) NOT NULL,
    name character varying(50) NOT NULL,
    last_update timestamp(0) without time zone DEFAULT now()
);


ALTER TABLE public.orderstatuses OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 42591)
-- Name: provinces_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.provinces_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.provinces_seq OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 42593)
-- Name: provinces; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.provinces (
    province_id integer DEFAULT nextval('public.provinces_seq'::regclass) NOT NULL,
    last_update timestamp(0) without time zone DEFAULT now(),
    province_name character varying(50) NOT NULL
);


ALTER TABLE public.provinces OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 42602)
-- Name: routes_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.routes_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.routes_seq OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 42604)
-- Name: routes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.routes (
    route_id integer DEFAULT nextval('public.routes_seq'::regclass) NOT NULL,
    route_from integer,
    route_to integer,
    route_status boolean DEFAULT true,
    last_update timestamp(0) without time zone DEFAULT now(),
    CONSTRAINT routes_check CHECK ((route_from <> route_to))
);


ALTER TABLE public.routes OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 42714)
-- Name: ticketdetails_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ticketdetails_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ticketdetails_seq OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 42716)
-- Name: ticketdetails; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ticketdetails (
    ticket_detail_id integer DEFAULT nextval('public.ticketdetails_seq'::regclass) NOT NULL,
    departure_date timestamp(0) without time zone DEFAULT now(),
    last_name character varying(50) NOT NULL,
    first_name character varying(50) NOT NULL,
    gender boolean DEFAULT true,
    age integer NOT NULL,
    num_seat integer NOT NULL,
    last_update timestamp(0) without time zone DEFAULT now(),
    ticket_id integer NOT NULL,
    order_id integer NOT NULL
);


ALTER TABLE public.ticketdetails OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 42653)
-- Name: tickets_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tickets_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tickets_seq OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 42655)
-- Name: tickets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tickets (
    ticket_id integer DEFAULT nextval('public.tickets_seq'::regclass) NOT NULL,
    bus_id integer NOT NULL,
    last_update timestamp(0) without time zone DEFAULT now(),
    ticket_status boolean DEFAULT true,
    discout double precision DEFAULT 0.0
);


ALTER TABLE public.tickets OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 42633)
-- Name: trips_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.trips_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.trips_seq OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 42635)
-- Name: trips; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trips (
    trip_id integer DEFAULT nextval('public.trips_seq'::regclass) NOT NULL,
    departure_time time(0) without time zone NOT NULL,
    arrival_time time(0) without time zone NOT NULL,
    route_id integer,
    unit_price double precision DEFAULT 0.0 NOT NULL,
    last_update timestamp(0) without time zone DEFAULT now(),
    bus_id integer
);


ALTER TABLE public.trips OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 42669)
-- Name: users_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_seq OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 42671)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id integer DEFAULT nextval('public.users_seq'::regclass) NOT NULL,
    user_name character varying(50),
    password character varying(100) NOT NULL,
    user_role integer DEFAULT 1,
    full_name character varying(100) NOT NULL,
    date_of_birth date,
    phone_num character varying(20) NOT NULL,
    email character varying(70) NOT NULL,
    gender boolean DEFAULT true,
    address character varying(100),
    CONSTRAINT users_user_role_check CHECK (((user_role > 0) AND (user_role < 4)))
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 3096 (class 0 OID 42625)
-- Dependencies: 205
-- Data for Name: bus; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bus (bus_id, bus_name, num_seat, bus_license_plate, last_update) FROM stdin;
1	The Beast 1	20	abc1234	2020-12-04 23:44:23
2	The Beast 2	20	abc1235	2020-12-04 23:44:23
3	The Beast 3	20	abc1236	2020-12-04 23:44:23
4	The Beast 4	20	abc1237	2020-12-04 23:44:23
5	The Beast 5	20	abc1238	2020-12-04 23:44:23
6	The Beast 6	20	abc123q	2020-12-04 23:44:23
7	The Beast 7	20	abc123w	2020-12-04 23:44:23
8	The Beast 8	20	abc123e	2020-12-04 23:44:23
9	The Beast 9	20	abc123egff	2020-12-04 23:44:23
10	The Beast 10	20	abc123r	2020-12-04 23:44:23
11	The Beast 11	20	abc1234t	2020-12-04 23:44:23
12	The Beast 12	20	abc1235y	2020-12-04 23:44:23
13	The Beast 13	20	abc1236u	2020-12-04 23:44:23
14	The Beast 14	20	abc123i7	2020-12-04 23:44:23
15	The Beast 15	20	abc1238	2020-12-04 23:44:23
16	The Beast 16	20	abc123qy	2020-12-04 23:44:23
17	The Beast 17	20	abc123wh	2020-12-04 23:44:23
18	The Beast 18	20	abc123engh	2020-12-04 23:44:23
19	The Beast 19	20	abc123r	2020-12-04 23:44:23
20	The Beast 20	20	abc123ryyyyy	2020-12-04 23:44:23
\.


--
-- TOC entry 3106 (class 0 OID 42693)
-- Dependencies: 215
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (order_id, amount, order_date, order_status_id, user_id, last_update, note) FROM stdin;
\.


--
-- TOC entry 3104 (class 0 OID 42684)
-- Dependencies: 213
-- Data for Name: orderstatuses; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orderstatuses (id, name, last_update) FROM stdin;
1	Processing	2020-12-04 23:48:52
2	Completed	2020-12-04 23:48:52
3	Canceled	2020-12-04 23:48:52
\.


--
-- TOC entry 3092 (class 0 OID 42593)
-- Dependencies: 201
-- Data for Name: provinces; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.provinces (province_id, last_update, province_name) FROM stdin;
1	2020-12-04 23:40:54	An Giang
2	2020-12-04 23:41:07	Bà Rịa - Vũng Tàu
3	2020-12-04 23:41:28	Bạc Liêu
4	2020-12-04 23:41:28	Bắc Kạn
5	2020-12-04 23:41:28	Bắc Giang
6	2020-12-04 23:41:28	Bắc Ninh
7	2020-12-04 23:41:28	Bến Tre\r\n
8	2020-12-04 23:41:28	Bình Dương
9	2020-12-04 23:41:28	Bình Định
10	2020-12-04 23:41:28	Bình Phước
11	2020-12-04 23:41:28	Bình Thuận
12	2020-12-04 23:41:28	Cà Mau
13	2020-12-04 23:41:28	Cao Bằng
14	2020-12-04 23:41:28	Cần Thơ
15	2020-12-04 23:41:28	Đà Nẵng
16	2020-12-04 23:41:28	Đắk Lắk
17	2020-12-04 23:41:28	Đắk Nông
18	2020-12-04 23:41:28	Đồng Nai
19	2020-12-04 23:41:28	Đồng Tháp
20	2020-12-04 23:41:28	Điện Biên
21	2020-12-04 23:41:28	Gia Lai
\.


--
-- TOC entry 3094 (class 0 OID 42604)
-- Dependencies: 203
-- Data for Name: routes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.routes (route_id, route_from, route_to, route_status, last_update) FROM stdin;
1	1	2	t	2020-12-04 23:45:49
2	2	1	t	2020-12-04 23:45:49
3	3	4	t	2020-12-04 23:45:49
4	4	3	t	2020-12-04 23:45:49
5	5	6	t	2020-12-04 23:45:49
6	6	5	t	2020-12-04 23:45:49
7	7	8	t	2020-12-04 23:45:49
8	8	7	t	2020-12-04 23:45:49
9	9	10	t	2020-12-04 23:45:49
10	10	9	t	2020-12-04 23:45:49
\.


--
-- TOC entry 3108 (class 0 OID 42716)
-- Dependencies: 217
-- Data for Name: ticketdetails; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ticketdetails (ticket_detail_id, departure_date, last_name, first_name, gender, age, num_seat, last_update, ticket_id, order_id) FROM stdin;
\.


--
-- TOC entry 3100 (class 0 OID 42655)
-- Dependencies: 209
-- Data for Name: tickets; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tickets (ticket_id, bus_id, last_update, ticket_status, discout) FROM stdin;
1	1	2020-12-04 23:46:48	t	0
2	1	2020-12-04 23:46:48	t	0
3	1	2020-12-04 23:46:48	t	0
4	1	2020-12-04 23:46:48	t	0
5	1	2020-12-04 23:46:48	t	0
6	1	2020-12-04 23:46:48	t	0
7	1	2020-12-04 23:46:48	t	0
8	1	2020-12-04 23:46:48	t	0
9	1	2020-12-04 23:46:48	t	0
10	1	2020-12-04 23:46:48	t	0
11	1	2020-12-04 23:46:48	t	0
12	1	2020-12-04 23:46:48	t	0
13	1	2020-12-04 23:46:48	t	0
14	1	2020-12-04 23:46:48	t	0
15	1	2020-12-04 23:46:48	t	0
16	1	2020-12-04 23:46:48	t	0
17	1	2020-12-04 23:46:48	t	0
18	1	2020-12-04 23:46:48	t	0
19	1	2020-12-04 23:46:48	t	0
20	1	2020-12-04 23:46:48	t	0
21	2	2020-12-04 23:46:48	t	0
22	2	2020-12-04 23:46:48	t	0
23	2	2020-12-04 23:46:48	t	0
24	2	2020-12-04 23:46:48	t	0
25	2	2020-12-04 23:46:48	t	0
26	2	2020-12-04 23:46:48	t	0
27	2	2020-12-04 23:46:48	t	0
28	2	2020-12-04 23:46:48	t	0
29	2	2020-12-04 23:46:48	t	0
30	2	2020-12-04 23:46:48	t	0
31	2	2020-12-04 23:46:48	t	0
32	2	2020-12-04 23:46:48	t	0
33	2	2020-12-04 23:46:48	t	0
34	2	2020-12-04 23:46:48	t	0
35	2	2020-12-04 23:46:48	t	0
36	2	2020-12-04 23:46:48	t	0
37	2	2020-12-04 23:46:48	t	0
38	2	2020-12-04 23:46:48	t	0
39	2	2020-12-04 23:46:48	t	0
40	2	2020-12-04 23:46:48	t	0
41	3	2020-12-04 23:46:48	t	0
42	3	2020-12-04 23:46:48	t	0
43	3	2020-12-04 23:46:48	t	0
44	3	2020-12-04 23:46:48	t	0
45	3	2020-12-04 23:46:48	t	0
46	3	2020-12-04 23:46:48	t	0
47	3	2020-12-04 23:46:48	t	0
48	3	2020-12-04 23:46:48	t	0
49	3	2020-12-04 23:46:48	t	0
50	3	2020-12-04 23:46:48	t	0
51	3	2020-12-04 23:46:48	t	0
52	3	2020-12-04 23:46:48	t	0
53	3	2020-12-04 23:46:48	t	0
54	3	2020-12-04 23:46:48	t	0
55	3	2020-12-04 23:46:48	t	0
56	3	2020-12-04 23:46:48	t	0
57	3	2020-12-04 23:46:48	t	0
58	3	2020-12-04 23:46:48	t	0
59	3	2020-12-04 23:46:48	t	0
60	3	2020-12-04 23:46:48	t	0
61	4	2020-12-04 23:47:29	t	0
62	4	2020-12-04 23:47:29	t	0
63	4	2020-12-04 23:47:29	t	0
64	4	2020-12-04 23:47:29	t	0
65	4	2020-12-04 23:47:29	t	0
66	4	2020-12-04 23:47:29	t	0
67	4	2020-12-04 23:47:29	t	0
68	4	2020-12-04 23:47:29	t	0
69	4	2020-12-04 23:47:29	t	0
70	4	2020-12-04 23:47:29	t	0
71	4	2020-12-04 23:47:29	t	0
72	4	2020-12-04 23:47:29	t	0
73	4	2020-12-04 23:47:29	t	0
74	4	2020-12-04 23:47:29	t	0
75	4	2020-12-04 23:47:29	t	0
76	4	2020-12-04 23:47:29	t	0
77	4	2020-12-04 23:47:29	t	0
78	4	2020-12-04 23:47:29	t	0
79	4	2020-12-04 23:47:29	t	0
80	4	2020-12-04 23:47:29	t	0
81	5	2020-12-04 23:47:29	t	0
82	5	2020-12-04 23:47:29	t	0
83	5	2020-12-04 23:47:29	t	0
84	5	2020-12-04 23:47:29	t	0
85	5	2020-12-04 23:47:29	t	0
86	5	2020-12-04 23:47:29	t	0
87	5	2020-12-04 23:47:29	t	0
88	5	2020-12-04 23:47:29	t	0
89	5	2020-12-04 23:47:29	t	0
90	5	2020-12-04 23:47:29	t	0
91	5	2020-12-04 23:47:29	t	0
92	5	2020-12-04 23:47:29	t	0
93	5	2020-12-04 23:47:29	t	0
94	5	2020-12-04 23:47:29	t	0
95	5	2020-12-04 23:47:29	t	0
96	5	2020-12-04 23:47:29	t	0
97	5	2020-12-04 23:47:29	t	0
98	5	2020-12-04 23:47:29	t	0
99	5	2020-12-04 23:47:29	t	0
100	5	2020-12-04 23:47:29	t	0
101	6	2020-12-04 23:47:29	t	0
102	6	2020-12-04 23:47:29	t	0
103	6	2020-12-04 23:47:29	t	0
104	6	2020-12-04 23:47:29	t	0
105	6	2020-12-04 23:47:29	t	0
106	6	2020-12-04 23:47:29	t	0
107	6	2020-12-04 23:47:29	t	0
108	6	2020-12-04 23:47:29	t	0
109	6	2020-12-04 23:47:29	t	0
110	6	2020-12-04 23:47:29	t	0
111	6	2020-12-04 23:47:29	t	0
112	6	2020-12-04 23:47:29	t	0
113	6	2020-12-04 23:47:29	t	0
114	6	2020-12-04 23:47:29	t	0
115	6	2020-12-04 23:47:29	t	0
116	6	2020-12-04 23:47:29	t	0
117	6	2020-12-04 23:47:29	t	0
118	6	2020-12-04 23:47:29	t	0
119	6	2020-12-04 23:47:29	t	0
120	6	2020-12-04 23:47:29	t	0
121	7	2020-12-04 23:47:29	t	0
122	7	2020-12-04 23:47:29	t	0
123	7	2020-12-04 23:47:29	t	0
124	7	2020-12-04 23:47:29	t	0
125	7	2020-12-04 23:47:29	t	0
126	7	2020-12-04 23:47:29	t	0
127	7	2020-12-04 23:47:29	t	0
128	7	2020-12-04 23:47:29	t	0
129	7	2020-12-04 23:47:29	t	0
130	7	2020-12-04 23:47:29	t	0
131	7	2020-12-04 23:47:29	t	0
132	7	2020-12-04 23:47:29	t	0
133	7	2020-12-04 23:47:29	t	0
134	7	2020-12-04 23:47:29	t	0
135	7	2020-12-04 23:47:29	t	0
136	7	2020-12-04 23:47:29	t	0
137	7	2020-12-04 23:47:29	t	0
138	7	2020-12-04 23:47:29	t	0
139	7	2020-12-04 23:47:29	t	0
140	7	2020-12-04 23:47:29	t	0
141	8	2020-12-04 23:47:29	t	0
142	8	2020-12-04 23:47:29	t	0
143	8	2020-12-04 23:47:29	t	0
144	8	2020-12-04 23:47:29	t	0
145	8	2020-12-04 23:47:29	t	0
146	8	2020-12-04 23:47:29	t	0
147	8	2020-12-04 23:47:29	t	0
148	8	2020-12-04 23:47:29	t	0
149	8	2020-12-04 23:47:29	t	0
150	8	2020-12-04 23:47:29	t	0
151	8	2020-12-04 23:47:29	t	0
152	8	2020-12-04 23:47:29	t	0
153	8	2020-12-04 23:47:29	t	0
154	8	2020-12-04 23:47:29	t	0
155	8	2020-12-04 23:47:29	t	0
156	8	2020-12-04 23:47:29	t	0
157	8	2020-12-04 23:47:29	t	0
158	8	2020-12-04 23:47:29	t	0
159	8	2020-12-04 23:47:29	t	0
160	8	2020-12-04 23:47:29	t	0
161	9	2020-12-04 23:47:29	t	0
162	9	2020-12-04 23:47:29	t	0
163	9	2020-12-04 23:47:29	t	0
164	9	2020-12-04 23:47:29	t	0
165	9	2020-12-04 23:47:29	t	0
166	9	2020-12-04 23:47:29	t	0
167	9	2020-12-04 23:47:29	t	0
168	9	2020-12-04 23:47:29	t	0
169	9	2020-12-04 23:47:29	t	0
170	9	2020-12-04 23:47:29	t	0
171	9	2020-12-04 23:47:29	t	0
172	9	2020-12-04 23:47:29	t	0
173	9	2020-12-04 23:47:29	t	0
174	9	2020-12-04 23:47:29	t	0
175	9	2020-12-04 23:47:29	t	0
176	9	2020-12-04 23:47:29	t	0
177	9	2020-12-04 23:47:29	t	0
178	9	2020-12-04 23:47:29	t	0
179	9	2020-12-04 23:47:29	t	0
180	9	2020-12-04 23:47:29	t	0
181	10	2020-12-04 23:47:29	t	0
182	10	2020-12-04 23:47:29	t	0
183	10	2020-12-04 23:47:29	t	0
184	10	2020-12-04 23:47:29	t	0
185	10	2020-12-04 23:47:29	t	0
186	10	2020-12-04 23:47:29	t	0
187	10	2020-12-04 23:47:29	t	0
188	10	2020-12-04 23:47:29	t	0
189	10	2020-12-04 23:47:29	t	0
190	10	2020-12-04 23:47:29	t	0
191	10	2020-12-04 23:47:29	t	0
192	10	2020-12-04 23:47:29	t	0
193	10	2020-12-04 23:47:29	t	0
194	10	2020-12-04 23:47:29	t	0
195	10	2020-12-04 23:47:29	t	0
196	10	2020-12-04 23:47:29	t	0
197	10	2020-12-04 23:47:29	t	0
198	10	2020-12-04 23:47:29	t	0
199	10	2020-12-04 23:47:29	t	0
200	10	2020-12-04 23:47:29	t	0
201	11	2020-12-04 23:47:29	t	0
202	11	2020-12-04 23:47:29	t	0
203	11	2020-12-04 23:47:29	t	0
204	11	2020-12-04 23:47:29	t	0
205	11	2020-12-04 23:47:29	t	0
206	11	2020-12-04 23:47:29	t	0
207	11	2020-12-04 23:47:29	t	0
208	11	2020-12-04 23:47:29	t	0
209	11	2020-12-04 23:47:29	t	0
210	11	2020-12-04 23:47:29	t	0
211	11	2020-12-04 23:47:29	t	0
212	11	2020-12-04 23:47:29	t	0
213	11	2020-12-04 23:47:29	t	0
214	11	2020-12-04 23:47:29	t	0
215	11	2020-12-04 23:47:29	t	0
216	11	2020-12-04 23:47:29	t	0
217	11	2020-12-04 23:47:29	t	0
218	11	2020-12-04 23:47:29	t	0
219	11	2020-12-04 23:47:29	t	0
220	11	2020-12-04 23:47:29	t	0
221	12	2020-12-04 23:47:29	t	0
222	12	2020-12-04 23:47:29	t	0
223	12	2020-12-04 23:47:29	t	0
224	12	2020-12-04 23:47:29	t	0
225	12	2020-12-04 23:47:29	t	0
226	12	2020-12-04 23:47:29	t	0
227	12	2020-12-04 23:47:29	t	0
228	12	2020-12-04 23:47:29	t	0
229	12	2020-12-04 23:47:29	t	0
230	12	2020-12-04 23:47:29	t	0
231	12	2020-12-04 23:47:29	t	0
232	12	2020-12-04 23:47:29	t	0
233	12	2020-12-04 23:47:29	t	0
234	12	2020-12-04 23:47:29	t	0
235	12	2020-12-04 23:47:29	t	0
236	12	2020-12-04 23:47:29	t	0
237	12	2020-12-04 23:47:29	t	0
238	12	2020-12-04 23:47:29	t	0
239	12	2020-12-04 23:47:29	t	0
240	12	2020-12-04 23:47:29	t	0
241	13	2020-12-04 23:47:29	t	0
242	13	2020-12-04 23:47:29	t	0
243	13	2020-12-04 23:47:29	t	0
244	13	2020-12-04 23:47:29	t	0
245	13	2020-12-04 23:47:29	t	0
246	13	2020-12-04 23:47:29	t	0
247	13	2020-12-04 23:47:29	t	0
248	13	2020-12-04 23:47:29	t	0
249	13	2020-12-04 23:47:29	t	0
250	13	2020-12-04 23:47:29	t	0
251	13	2020-12-04 23:47:29	t	0
252	13	2020-12-04 23:47:29	t	0
253	13	2020-12-04 23:47:29	t	0
254	13	2020-12-04 23:47:29	t	0
255	13	2020-12-04 23:47:29	t	0
256	13	2020-12-04 23:47:29	t	0
257	13	2020-12-04 23:47:29	t	0
258	13	2020-12-04 23:47:29	t	0
259	13	2020-12-04 23:47:29	t	0
260	13	2020-12-04 23:47:29	t	0
261	14	2020-12-04 23:47:29	t	0
262	14	2020-12-04 23:47:29	t	0
263	14	2020-12-04 23:47:29	t	0
264	14	2020-12-04 23:47:29	t	0
265	14	2020-12-04 23:47:29	t	0
266	14	2020-12-04 23:47:29	t	0
267	14	2020-12-04 23:47:29	t	0
268	14	2020-12-04 23:47:29	t	0
269	14	2020-12-04 23:47:29	t	0
270	14	2020-12-04 23:47:29	t	0
271	14	2020-12-04 23:47:29	t	0
272	14	2020-12-04 23:47:29	t	0
273	14	2020-12-04 23:47:29	t	0
274	14	2020-12-04 23:47:29	t	0
275	14	2020-12-04 23:47:29	t	0
276	14	2020-12-04 23:47:29	t	0
277	14	2020-12-04 23:47:29	t	0
278	14	2020-12-04 23:47:29	t	0
279	14	2020-12-04 23:47:29	t	0
280	14	2020-12-04 23:47:29	t	0
281	15	2020-12-04 23:47:29	t	0
282	15	2020-12-04 23:47:29	t	0
283	15	2020-12-04 23:47:29	t	0
284	15	2020-12-04 23:47:29	t	0
285	15	2020-12-04 23:47:29	t	0
286	15	2020-12-04 23:47:29	t	0
287	15	2020-12-04 23:47:29	t	0
288	15	2020-12-04 23:47:29	t	0
289	15	2020-12-04 23:47:29	t	0
290	15	2020-12-04 23:47:29	t	0
291	15	2020-12-04 23:47:29	t	0
292	15	2020-12-04 23:47:29	t	0
293	15	2020-12-04 23:47:29	t	0
294	15	2020-12-04 23:47:29	t	0
295	15	2020-12-04 23:47:29	t	0
296	15	2020-12-04 23:47:29	t	0
297	15	2020-12-04 23:47:29	t	0
298	15	2020-12-04 23:47:29	t	0
299	15	2020-12-04 23:47:29	t	0
300	15	2020-12-04 23:47:29	t	0
301	16	2020-12-04 23:47:29	t	0
302	16	2020-12-04 23:47:29	t	0
303	16	2020-12-04 23:47:29	t	0
304	16	2020-12-04 23:47:29	t	0
305	16	2020-12-04 23:47:29	t	0
306	16	2020-12-04 23:47:29	t	0
307	16	2020-12-04 23:47:29	t	0
308	16	2020-12-04 23:47:29	t	0
309	16	2020-12-04 23:47:29	t	0
310	16	2020-12-04 23:47:29	t	0
311	16	2020-12-04 23:47:29	t	0
312	16	2020-12-04 23:47:29	t	0
313	16	2020-12-04 23:47:29	t	0
314	16	2020-12-04 23:47:29	t	0
315	16	2020-12-04 23:47:29	t	0
316	16	2020-12-04 23:47:29	t	0
317	16	2020-12-04 23:47:29	t	0
318	16	2020-12-04 23:47:29	t	0
319	16	2020-12-04 23:47:29	t	0
320	16	2020-12-04 23:47:29	t	0
321	17	2020-12-04 23:47:29	t	0
322	17	2020-12-04 23:47:29	t	0
323	17	2020-12-04 23:47:29	t	0
324	17	2020-12-04 23:47:29	t	0
325	17	2020-12-04 23:47:29	t	0
326	17	2020-12-04 23:47:29	t	0
327	17	2020-12-04 23:47:29	t	0
328	17	2020-12-04 23:47:29	t	0
329	17	2020-12-04 23:47:29	t	0
330	17	2020-12-04 23:47:29	t	0
331	17	2020-12-04 23:47:29	t	0
332	17	2020-12-04 23:47:29	t	0
333	17	2020-12-04 23:47:29	t	0
334	17	2020-12-04 23:47:29	t	0
335	17	2020-12-04 23:47:29	t	0
336	17	2020-12-04 23:47:29	t	0
337	17	2020-12-04 23:47:29	t	0
338	17	2020-12-04 23:47:29	t	0
339	17	2020-12-04 23:47:29	t	0
340	17	2020-12-04 23:47:29	t	0
341	18	2020-12-04 23:47:29	t	0
342	18	2020-12-04 23:47:29	t	0
343	18	2020-12-04 23:47:29	t	0
344	18	2020-12-04 23:47:29	t	0
345	18	2020-12-04 23:47:29	t	0
346	18	2020-12-04 23:47:29	t	0
347	18	2020-12-04 23:47:29	t	0
348	18	2020-12-04 23:47:29	t	0
349	18	2020-12-04 23:47:29	t	0
350	18	2020-12-04 23:47:29	t	0
351	18	2020-12-04 23:47:29	t	0
352	18	2020-12-04 23:47:29	t	0
353	18	2020-12-04 23:47:29	t	0
354	18	2020-12-04 23:47:29	t	0
355	18	2020-12-04 23:47:29	t	0
356	18	2020-12-04 23:47:29	t	0
357	18	2020-12-04 23:47:29	t	0
358	18	2020-12-04 23:47:29	t	0
359	18	2020-12-04 23:47:29	t	0
360	18	2020-12-04 23:47:29	t	0
361	19	2020-12-04 23:47:29	t	0
362	19	2020-12-04 23:47:29	t	0
363	19	2020-12-04 23:47:29	t	0
364	19	2020-12-04 23:47:29	t	0
365	19	2020-12-04 23:47:29	t	0
366	19	2020-12-04 23:47:29	t	0
367	19	2020-12-04 23:47:29	t	0
368	19	2020-12-04 23:47:29	t	0
369	19	2020-12-04 23:47:29	t	0
370	19	2020-12-04 23:47:29	t	0
371	19	2020-12-04 23:47:29	t	0
372	19	2020-12-04 23:47:29	t	0
373	19	2020-12-04 23:47:29	t	0
374	19	2020-12-04 23:47:29	t	0
375	19	2020-12-04 23:47:29	t	0
376	19	2020-12-04 23:47:29	t	0
377	19	2020-12-04 23:47:29	t	0
378	19	2020-12-04 23:47:29	t	0
379	19	2020-12-04 23:47:29	t	0
380	19	2020-12-04 23:47:29	t	0
381	20	2020-12-04 23:47:29	t	0
382	20	2020-12-04 23:47:29	t	0
383	20	2020-12-04 23:47:29	t	0
384	20	2020-12-04 23:47:29	t	0
385	20	2020-12-04 23:47:29	t	0
386	20	2020-12-04 23:47:29	t	0
387	20	2020-12-04 23:47:29	t	0
388	20	2020-12-04 23:47:29	t	0
389	20	2020-12-04 23:47:29	t	0
390	20	2020-12-04 23:47:29	t	0
391	20	2020-12-04 23:47:29	t	0
392	20	2020-12-04 23:47:29	t	0
393	20	2020-12-04 23:47:29	t	0
394	20	2020-12-04 23:47:29	t	0
395	20	2020-12-04 23:47:29	t	0
396	20	2020-12-04 23:47:29	t	0
397	20	2020-12-04 23:47:29	t	0
398	20	2020-12-04 23:47:29	t	0
399	20	2020-12-04 23:47:29	t	0
400	20	2020-12-04 23:47:29	t	0
\.


--
-- TOC entry 3098 (class 0 OID 42635)
-- Dependencies: 207
-- Data for Name: trips; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.trips (trip_id, departure_time, arrival_time, route_id, unit_price, last_update, bus_id) FROM stdin;
4	05:30:00	09:30:00	2	300	2020-12-04 23:46:35	3
5	12:30:00	16:30:00	2	400	2020-12-04 23:46:35	4
6	05:30:00	09:30:00	3	500	2020-12-04 23:46:35	5
7	12:30:00	16:30:00	3	600	2020-12-04 23:46:35	6
8	05:30:00	09:30:00	4	700	2020-12-04 23:46:35	7
9	12:30:00	16:30:00	4	800	2020-12-04 23:46:35	8
10	05:30:00	09:30:00	5	900	2020-12-04 23:46:35	9
11	12:30:00	16:30:00	5	1000	2020-12-04 23:46:35	10
12	12:30:00	16:30:00	6	1100	2020-12-04 23:46:35	11
13	08:30:00	12:30:00	6	1200	2020-12-04 23:46:35	12
14	12:30:00	19:30:00	7	1300	2020-12-04 23:46:35	13
15	14:30:00	21:30:00	7	1400	2020-12-04 23:46:35	14
16	12:30:00	17:30:00	8	1500	2020-12-04 23:46:35	15
17	14:30:00	19:30:00	8	1600	2020-12-04 23:46:35	16
18	12:30:00	18:30:00	9	1700	2020-12-04 23:46:35	17
19	13:30:00	19:30:00	9	1800	2020-12-04 23:46:35	18
20	12:30:00	20:30:00	10	1900	2020-12-04 23:46:35	19
21	13:30:00	21:30:00	10	2000	2020-12-04 23:46:35	20
\.


--
-- TOC entry 3102 (class 0 OID 42671)
-- Dependencies: 211
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, user_name, password, user_role, full_name, date_of_birth, phone_num, email, gender, address) FROM stdin;
1	cus01	1234	1	Tran Trung Truc	1997-04-22	0934234234	tructt@fsoft.com.vn	t	Tien Giang
2	cus02	1234	1	Le Trung Truc	1997-04-22	0934234234	reuctt@fsoft.com.vn	f	Tien Giang
3	cus03	1234	1	Tran thu Truc	1997-04-22	0934234234	tyutt@fsoft.com.vn	t	Tien Giang
4	cus04	1234	1	Trrt wwr Truc	1997-04-22	0934234234	tgstt@fsoft.com.vn	f	Tien Giang
5	cus05	1234	1	Hunh Hong Song	1997-04-22	0934234234	thongt@fsoft.com.vn	t	Tien Giang
6	sta01	1234	2	Hoang Mai Huy	1997-04-22	0934234234	sssst@fsoft.com.vn	f	Tien Giang
7	sta02	1234	2	Hoang Mai Truong	1997-04-22	0933234234	sshjkt@fsoft.com.vn	t	Tien Giang
8	sta03	1234	2	Tran Mai Truong	1997-04-22	093124234	466t@fsoft.com.vn	f	Tien Giang
9	adm01	1234	3	Ngo Mai Truong	1997-04-22	09313234	4ngoit@fsoft.com.vn	t	Tien Giang
10	adm02	1234	3	Tran Mai Thu	1997-04-22	09313234	4thut@fsoft.com.vn	f	Tien Giang
\.


--
-- TOC entry 3115 (class 0 OID 0)
-- Dependencies: 204
-- Name: bus_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bus_seq', 40, true);


--
-- TOC entry 3116 (class 0 OID 0)
-- Dependencies: 214
-- Name: orders_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_seq', 1, false);


--
-- TOC entry 3117 (class 0 OID 0)
-- Dependencies: 212
-- Name: orderstatuses_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orderstatuses_seq', 3, true);


--
-- TOC entry 3118 (class 0 OID 0)
-- Dependencies: 200
-- Name: provinces_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.provinces_seq', 42, true);


--
-- TOC entry 3119 (class 0 OID 0)
-- Dependencies: 202
-- Name: routes_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.routes_seq', 22, true);


--
-- TOC entry 3120 (class 0 OID 0)
-- Dependencies: 216
-- Name: ticketdetails_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ticketdetails_seq', 1, false);


--
-- TOC entry 3121 (class 0 OID 0)
-- Dependencies: 208
-- Name: tickets_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tickets_seq', 400, true);


--
-- TOC entry 3122 (class 0 OID 0)
-- Dependencies: 206
-- Name: trips_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.trips_seq', 21, true);


--
-- TOC entry 3123 (class 0 OID 0)
-- Dependencies: 210
-- Name: users_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_seq', 10, true);


--
-- TOC entry 2937 (class 2606 OID 42632)
-- Name: bus bus_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bus
    ADD CONSTRAINT bus_pkey PRIMARY KEY (bus_id);


--
-- TOC entry 2949 (class 2606 OID 42703)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (order_id);


--
-- TOC entry 2947 (class 2606 OID 42690)
-- Name: orderstatuses orderstatuses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderstatuses
    ADD CONSTRAINT orderstatuses_pkey PRIMARY KEY (id);


--
-- TOC entry 2931 (class 2606 OID 42599)
-- Name: provinces provinces_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provinces
    ADD CONSTRAINT provinces_pkey PRIMARY KEY (province_id);


--
-- TOC entry 2933 (class 2606 OID 42601)
-- Name: provinces provinces_province_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provinces
    ADD CONSTRAINT provinces_province_name_key UNIQUE (province_name);


--
-- TOC entry 2935 (class 2606 OID 42612)
-- Name: routes routes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.routes
    ADD CONSTRAINT routes_pkey PRIMARY KEY (route_id);


--
-- TOC entry 2951 (class 2606 OID 42724)
-- Name: ticketdetails ticketdetails_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticketdetails
    ADD CONSTRAINT ticketdetails_pkey PRIMARY KEY (ticket_detail_id);


--
-- TOC entry 2941 (class 2606 OID 42663)
-- Name: tickets tickets_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT tickets_pkey PRIMARY KEY (ticket_id);


--
-- TOC entry 2939 (class 2606 OID 42642)
-- Name: trips trips_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trips
    ADD CONSTRAINT trips_pkey PRIMARY KEY (trip_id);


--
-- TOC entry 2943 (class 2606 OID 42679)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2945 (class 2606 OID 42681)
-- Name: users users_user_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_user_name_key UNIQUE (user_name);


--
-- TOC entry 2958 (class 2606 OID 42709)
-- Name: orders orders_order_status_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_order_status_id_fkey FOREIGN KEY (order_status_id) REFERENCES public.orderstatuses(id);


--
-- TOC entry 2957 (class 2606 OID 42704)
-- Name: orders orders_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 2952 (class 2606 OID 42613)
-- Name: routes routes_route_from_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.routes
    ADD CONSTRAINT routes_route_from_fkey FOREIGN KEY (route_from) REFERENCES public.provinces(province_id);


--
-- TOC entry 2953 (class 2606 OID 42618)
-- Name: routes routes_route_to_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.routes
    ADD CONSTRAINT routes_route_to_fkey FOREIGN KEY (route_to) REFERENCES public.provinces(province_id);


--
-- TOC entry 2960 (class 2606 OID 42730)
-- Name: ticketdetails ticketdetails_order_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticketdetails
    ADD CONSTRAINT ticketdetails_order_id_fkey FOREIGN KEY (order_id) REFERENCES public.orders(order_id);


--
-- TOC entry 2959 (class 2606 OID 42725)
-- Name: ticketdetails ticketdetails_ticket_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticketdetails
    ADD CONSTRAINT ticketdetails_ticket_id_fkey FOREIGN KEY (ticket_id) REFERENCES public.tickets(ticket_id);


--
-- TOC entry 2956 (class 2606 OID 42664)
-- Name: tickets tickets_bus_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT tickets_bus_id_fkey FOREIGN KEY (bus_id) REFERENCES public.bus(bus_id);


--
-- TOC entry 2954 (class 2606 OID 42643)
-- Name: trips trips_bus_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trips
    ADD CONSTRAINT trips_bus_id_fkey FOREIGN KEY (bus_id) REFERENCES public.bus(bus_id);


--
-- TOC entry 2955 (class 2606 OID 42648)
-- Name: trips trips_route_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trips
    ADD CONSTRAINT trips_route_id_fkey FOREIGN KEY (route_id) REFERENCES public.routes(route_id);


-- Completed on 2020-12-04 23:49:26

--
-- PostgreSQL database dump complete
--

