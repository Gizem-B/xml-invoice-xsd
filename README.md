
# XML Invoice Validator API

## 📌 Project Description

This project receives Base64-encoded XML invoices, validates them against an XSD schema, converts them into Java objects using JAXB, and saves selected fields to a PostgreSQL database.

---

## 🔧 Technologies Used

- Java 17  
- Spring Boot 3.2.8  
- Spring Web  
- Spring Data JPA  
- PostgreSQL  
- JAXB (`jakarta.xml.bind`)  
- Swagger (via `springdoc-openapi`)  

---

## 🚀 API Summary

### `POST /api/invoices`

Receives a JSON request with a Base64-encoded XML string.

#### ✅ Successful Request

**Request Body:**
```json
{
  "base64xml": "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KPEZha3R1cmEgeG1sbnM6eHNkPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYSIgeG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0YW5jZSIgeG1sbnM9Imh0dHA6Ly9jcmQuZ292LnBsL3d6b3IvMjAyMy8wNi8yOS8xMjY0OC8iPgogICAgPE5hZ2xvd2VrPgogICAgICAgIDxLb2RGb3JtdWxhcnphIGtvZFN5c3RlbW93eT0iRkEgKDIpIiB3ZXJzamFTY2hlbXk9IjEtMEUiPkZBPC9Lb2RGb3JtdWxhcnphPgogICAgICAgIDxXYXJpYW50Rm9ybXVsYXJ6YT4yPC9XYXJpYW50Rm9ybXVsYXJ6YT4KICAgICAgICA8RGF0YVd5dHdvcnplbmlhRmE+MjAyMy0wOC0yOVQxMjozNDoxMy43ODAyNTcxWjwvRGF0YVd5dHdvcnplbmlhRmE+CiAgICAgICAgPFN5c3RlbUluZm8+U2FtcGxvZmFrdHVyPC9TeXN0ZW1JbmZvPgogICAgPC9OYWdsb3dlaz4KICAgIDxQb2RtaW90MT4KICAgICAgICA8RGFuZUlkZW50eWZpa2FjeWpuZT4KICAgICAgICAgICAgPE5JUD45NzgxMzk5MjU5PC9OSVA+CiAgICAgICAgICAgIDxOYXp3YT5BQkMgQUdEIHNwLiB6IG8uIG8uPC9OYXp3YT4KICAgICAgICA8L0RhbmVJZGVudHlmaWthY3lqbmU+CiAgICAgICAgPEFkcmVzPgogICAgICAgICAgICA8S29kS3JhanU+UEw8L0tvZEtyYWp1PgogICAgICAgICAgICA8QWRyZXNMMT51bC4gS3dpYXRvd2EgMTwvQWRyZXNMMT4KICAgICAgICA8L0FkcmVzPgogICAgICAgIDxEYW5lS29udGFrdG93ZT4KICAgICAgICAgICAgPEVtYWlsPmV4YW1wbGVAZXhhbXBsZS5jb208L0VtYWlsPgogICAgICAgIDwvRGFuZUtvbnRha3Rvd2U+CiAgICA8L1BvZG1pb3QxPgogICAgPFBvZG1pb3QyPgogICAgICAgIDxEYW5lSWRlbnR5ZmlrYWN5am5lPgogICAgICAgICAgICA8TklQPjEyNTA3NTM1MDU8L05JUD4KICAgICAgICAgICAgPE5hendhPkNlRGVFIHMuYy48L05hendhPgogICAgICAgIDwvRGFuZUlkZW50eWZpa2FjeWpuZT4KICAgICAgICA8QWRyZXM+CiAgICAgICAgICAgIDxLb2RLcmFqdT5QTDwvS29kS3JhanU+CiAgICAgICAgICAgIDxBZHJlc0wxPnVsaWNhIGkgbnVtZXI8L0FkcmVzTDE+CiAgICAgICAgPC9BZHJlcz4KICAgIDwvUG9kbWlvdDI+CiAgICA8RmE+CiAgICAgICAgPEtvZFdhbHV0eT5QTE48L0tvZFdhbHV0eT4KICAgICAgICA8UF8xPjIwMjMtMDgtMzE8L1BfMT4KICAgICAgICA8UF8yPkZLMjAyMy8wOC8zMTwvUF8yPgogICAgICAgIDxQXzEzXzE+MDwvUF8xM18xPgogICAgICAgIDxQXzE0XzE+MDwvUF8xNF8xPgogICAgICAgIDxQXzEzXzI+MDwvUF8xM18yPgogICAgICAgIDxQXzE0XzI+MDwvUF8xNF8yPgogICAgICAgIDxQXzEzXzM+MDwvUF8xM18zPgogICAgICAgIDxQXzE0XzM+MDwvUF8xNF8zPgogICAgICAgIDxQXzEzXzQ+MDwvUF8xM180PgogICAgICAgIDxQXzE0XzQ+MDwvUF8xNF80PgogICAgICAgIDxQXzEzXzU+MDwvUF8xM181PgogICAgICAgIDxQXzEzXzc+NDAwMS40OTwvUF8xM183PgogICAgICAgIDxQXzE1PjQwMDEuNDk8L1BfMTU+CiAgICAgICAgPEFkbm90YWNqZT4KICAgICAgICAgICAgPFBfMTY+MjwvUF8xNj4KICAgICAgICAgICAgPFBfMTc+MjwvUF8xNz4KICAgICAgICAgICAgPFBfMTg+MjwvUF8xOD4KICAgICAgICAgICAgPFBfMThBPjI8L1BfMThBPgogICAgICAgICAgICA8WndvbG5pZW5pZT4KICAgICAgICAgICAgICAgIDxQXzE5Tj4xPC9QXzE5Tj4KICAgICAgICAgICAgPC9ad29sbmllbmllPgogICAgICAgICAgICA8Tm93ZVNyb2RraVRyYW5zcG9ydHU+CiAgICAgICAgICAgICAgICA8UF8yMk4+MTwvUF8yMk4+CiAgICAgICAgICAgIDwvTm93ZVNyb2RraVRyYW5zcG9ydHU+CiAgICAgICAgICAgIDxQXzIzPjI8L1BfMjM+CiAgICAgICAgICAgIDxQTWFyenk+CiAgICAgICAgICAgICAgICA8UF9QTWFyenlOPjE8L1BfUE1hcnp5Tj4KICAgICAgICAgICAgPC9QTWFyenk+CiAgICAgICAgPC9BZG5vdGFjamU+CiAgICAgICAgPFJvZHphakZha3R1cnk+VkFUPC9Sb2R6YWpGYWt0dXJ5PgogICAgICAgIDxGYVdpZXJzej4KICAgICAgICAgICAgPE5yV2llcnN6YUZhPjE8L05yV2llcnN6YUZhPgogICAgICAgICAgICA8UF83PlNwcnplZGHFvCB0b3dhcsOzdyAyMyU8L1BfNz4KICAgICAgICAgICAgPFBfOEE+c3p0LjwvUF84QT4KICAgICAgICAgICAgPFBfOEI+Mi4zMjM8L1BfOEI+CiAgICAgICAgICAgIDxQXzlBPjIzNC4yNDwvUF85QT4KICAgICAgICAgICAgPFBfMTE+NTQ0LjE0PC9QXzExPgogICAgICAgICAgICA8UF8xMj56dzwvUF8xMj4KICAgICAgICA8L0ZhV2llcnN6PgogICAgICAgIDxGYVdpZXJzej4KICAgICAgICAgICAgPE5yV2llcnN6YUZhPjI8L05yV2llcnN6YUZhPgogICAgICAgICAgICA8UF83PkdUVV8xPC9QXzc+CiAgICAgICAgICAgIDxQXzhBPi08L1BfOEE+CiAgICAgICAgICAgIDxQXzhCPjIuNTYxPC9QXzhCPgogICAgICAgICAgICA8UF85QT4xMzUwLjAwPC9QXzlBPgogICAgICAgICAgICA8UF8xMT4zNDU3LjM1PC9QXzExPgogICAgICAgICAgICA8UF8xMj56dzwvUF8xMj4KICAgICAgICA8L0ZhV2llcnN6PgogICAgPC9GYT4KPC9GYWt0dXJhPg=="
}

```

**Response:**
```json
{
  "message": "Invoice saved successfully"
}
```

#### ❌ Invalid XML Schema (400 Bad Request)

**Request Body:**
```json
{
    "base64xml": "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KPEZha3R1cmEgeG1sbnM6eHNkPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYSIgeG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0YW5jZSIgeG1sbnM9Imh0dHA6Ly9jcmQuZ292LnBsL3d6b3IvMjAyMy8wNi8yOS8xMjY0OC8iPgogICAgPE5hZ2xvd2VrPgogICAgICAgIDxLb2RGb3JtdWxhcnphIGtvZFN5c3RlbW93eT0iRkEgKDIpIiB3ZXJzamFTY2hlbXk9IjEtMEUiPkZBPC9Lb2RGb3JtdWxhcnphPgogICAgICAgIDxXYXJpYW50Rm9ybXVsYXJ6YT4yPC9XYXJpYW50Rm9ybXVsYXJ6YT4KICAgICAgICA8RGF0YVd5dHdvcnplbmlhRmE+MjAyMy0wOC0yOVQxMjozNDoxMy43ODAyNTcxWjwvRGF0YVd5dHdvcnplbmlhRmE+CiAgICAgICAgPFN5c3RlbUluZm8+U2FtcGxvZmFrdHVyPC9TeXN0ZW1JbmZvPgogICAgPC9OYWdsb3dlaz4KICAgICA8UG9kbWlvdDE+CiAgICAgICAgPERhbmVJZGVudHlmaWthY3luaWU+CiAgICAgICAgICAgIDxOSVA+OTc4MTM5OTI1OTwvTklQPgogICAgICAgICAgICA8TmF6d2E+QUJDIEFHRCBzcC4gem8uIG8uPC9OYXp3YT4KICAgICAgICA8L0RhbmVJZGVudHlmaWthenluaWU+CiAgICAgICAgPEFkcmVzPgogICAgICAgICAgICA8S29kS3JhamU+UEw8L0tvZEtyYWp1PgogICAgICAgICAgICA8QWRyZXNMMT51bC4gS3dpYXRvd2EgMTwvQWRyZXNMMT4KICAgICAgICA8L0FkcmVzPgogICAgICAgIDxEYW5lS29udGFrdG93ZT4KICAgICAgICAgICAgPEVtYWlsPmV4YW1wbGVAZXhhbXBsZS5jb208L0VtYWlsPgogICAgICAgIDwvRGFuZUtvbnRha3Rvd2U+CiAgICA8L1BvZG1pb3QxPgogICAgPFBvZG1pb3QyPgogICAgICAgIDxEYW5lSWRlbnR5ZmlrYWN5bmllPgogICAgICAgICAgICA8TklQPjEyNTA3NTM1MDU8L05JUD4KICAgICAgICAgICAgPE5hendhPkNlRGVFIGMuYy48L05hendhPgogICAgICAgIDwvRGFuZUlkZW50eWZpY2FjeW5pZT4KICAgICAgICA8QWRyZXM+CiAgICAgICAgICAgIDxLb2RLcmFqdT5QTDwvS29kS3JhanU+CiAgICAgICAgICAgIDxBZHJlc0wxPnVsaWNhIGkgbnVtZXI8L0FkcmVzTDE+CiAgICAgICAgPC9BZHJlcz4KICAgIDwvUG9kbWlvdDI+CiAgICA8RmE+CiAgICAgICAgPEtvZFdhbHV0eT5QTE48L0tvZFdhbHV0eT4KICAgICAgICA8UF8xPjIwMjMtMDgtMzE8L1BfMT4KICAgICAgICA8UF8yPkZLMjAyMy8wOC8zMTwvUF8yPgogICAgICAgIDxQXzEzXzE+MDwvUF8xM18xPgogICAgICAgIDxQXzE0XzE+MDwvUF8xNF8xPgogICAgICAgIDxQXzEzXzI+MDwvUF8xM18yPgogICAgICAgIDxQXzE0XzI+MDwvUF8xNF8yPgogICAgICAgIDxQXzEzXzM+MDwvUF8xM18zPgogICAgICAgIDxQXzE0XzM+MDwvUF8xNF8zPgogICAgICAgIDxQXzEzXzQ+MDwvUF8xM180PgogICAgICAgIDxQXzE0XzQ+MDwvUF8xNF80PgogICAgICAgIDxQXzEzXzU+MDwvUF8xM181PgogICAgICAgIDxQXzEzXzc+NDAwMS40OTwvUF8xM183PgogICAgICAgIDxQXzE1PjQwMDEuNDk8L1BfMTU+CiAgICAgICAgPEFkbm90YWNqZT4KICAgICAgICAgICAgPFBfMTY+MjwvUF8xNj4KICAgICAgICAgICAgPFBfMTc+MjwvUF8xNz4KICAgICAgICAgICAgPFBfMTg+MjwvUF8xOD4KICAgICAgICAgICAgPFBfMThBPjI8L1BfMThBPgogICAgICAgICAgICA8WndvbG5pZW5pZT4KICAgICAgICAgICAgICAgIDxQXzE5Tj4xPC9QXzE5Tj4KICAgICAgICAgICAgPC9ad29sbmllbmllPgogICAgICAgICAgICA8Tm93ZVNyb2RraVRyYW5zcG9ydHU+CiAgICAgICAgICAgICAgICA8UF8yMk4+MTwvUF8yMk4+CiAgICAgICAgICAgIDwvTm93ZVNyb2RraVRyYW5zcG9ydHU+CiAgICAgICAgICAgIDxQXzIzPjI8L1BfMjM+CiAgICAgICAgICAgIDxQTWFyenk+CiAgICAgICAgICAgICAgICA8UF9QTWFyenlOPjE8L1BfUFNhenlOPgogICAgICAgICAgICA8L1BNYXJ6eT4KICAgICAgICA8L0Fkbm90YWNqZT4KICAgICAgICA8Um9kemFqRmFrdHVyeT5WQVQ8L1JvZHphamZha3R1cnk+CiAgICAgICAgPEZhV2llcnN6PgogICAgICAgICAgICA8TnJXaWVyc3phRmE+MTwvTnJXaWVyc3phRmE+CiAgICAgICAgICAgIDxQXzc+U3ByemVkYcWcIHRvd2Fyw7N3IDIzJTwvUF83PgogICAgICAgICAgICA8UF84QT5zenQuPC9QXzhBPgogICAgICAgICAgICA8UF84Qj4yLjMyMzwvUF84Qj4KICAgICAgICAgICAgPFBfOUE+MjM0LjI0PC9QXzlBPgogICAgICAgICAgICA8UF8xMT41NDQuMTQ8L1BfMTE+CiAgICAgICAgICAgIDxQXzEyPnp3PC9QXzEyPgogICAgICAgIDwvRmFXaWVyc3o+CiAgICAgICAgPEZhV2llcnN6PgogICAgICAgICAgICA8TnJXaWVyc3phRmE+MjwvTnJXaWVyc3phRmE+CiAgICAgICAgICAgIDxQXzc+R1RVXzE8L1BfNz4KICAgICAgICAgICAgPFBfOEE+LTwvUF84QT4KICAgICAgICAgICAgPFBfOEI+Mi41NjE8L1BfOEI+CiAgICAgICAgICAgIDxQXzlBPjEzNTAuMDA8L1BfOUE+CiAgICAgICAgICAgIDxQXzExPjM0NTcuMzU8L1BfMTE+CiAgICAgICAgICAgIDxQXzEyPnp3PC9QXzEyPgogICAgICAgIDwvRmFXaWVyeno+CiAgICA8L0ZhPgo8L0Zha3R1cmE+Cg=="
}
```
**Response:**
```json
{    "message": "The provided XML does not conform to the XSD schema. Details: XML      validation failed: cvc-complex-type.2.4.a: Invalid content was found starting with element '{\"http://crd.gov.pl/wzor/2023/06/29/12648/\":DaneIdentyfikacynie}'. One of '{\"http://crd.gov.pl/wzor/2023/06/29/12648/\":DaneIdentyfikacyjne}' is expected.",
    "error": "XML Validation Error"
}

```

#### ❌ Invalid Base64 (500 Internal Server Error)

```json
**Request Body:**
{
    "base64xml": "PHNwZWNpZmljYXRpb24geG1sbnM9Imh0dHA6Ly9...=="
}
```
**Response:**
```json
{
    "error": "Internal Server Error",
    "message": "Illegal base64 character 2e"
}


```

---

## 🔄 Workflow Steps

1. XML is decoded from Base64 (UTF-8).
2. XML is validated against `resources/xsd/schema.xsd`.
3. A `Faktura` object is created via JAXB.
4. Extracted fields:
   - `Faktura → Podmiot1 → DaneIdentyfikacyjne → NIP`
   - `Faktura → Fa → P1`, `P2`
5. Data is mapped to `InvoiceEntity` and saved.
6. Returns HTTP 201 if successful.
7. Errors are handled globally via `@ControllerAdvice`.

---

## 📚 Swagger Interface

Swagger UI is available at:  
**[http://localhost:8090/docs]**

---

## 🗄️ Database Structure

Table: `invoices`

| Column | Description               |
|--------|---------------------------|
| `id`   | Auto-generated primary key|
| `nip`  | Company tax number        |
| `p1`   | Invoice field P1          |
| `p2`   | Invoice field P2          |

---

## ⚙️ Running the Project

1. Ensure PostgreSQL is running and a database named `postgres` is created.
2. Add the following config to `src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgres
    username: postgres
    password: root

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```
3. Start the project using your IDE or command line.

---

## 🛠️ Converting XSD to Java

Use the following command:
```bash
xjc -d src/main/java/generated -p com.melasoft.xsdvalidater schema.xsd
```

---

