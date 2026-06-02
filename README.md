# 🚚 Kargo Takip Sistemi

🌐 **Canlı Demo:** [cargo-tracking-system.up.railway.app](https://cargo-tracking-system.up.railway.app)

Java Spring Boot ve PostgreSQL ile geliştirilmiş kargo yönetim uygulaması.

## 🛠️ Teknolojiler

- Java 17, Spring Boot 3.5.14
- Spring Data JPA, Spring Security, Hibernate
- PostgreSQL (Docker), Lombok, Maven
- HTML / CSS / JavaScript (Ön yüz)

## 📦 Özellikler

- Otomatik takip numarasıyla gönderi yönetimi
- Müşteri ve taşıyıcı yönetimi
- Gerçek zamanlı kargo takibi
- Rol tabanlı erişim kontrolü (KULLANICI / YÖNETİCİ)

## 📁 Dosya Yapısı

```
cargotrackingsystem/
├── src/
│   └── main/
│       ├── java/com/cargotracking/cargotrackingsystem/
│       │   ├── controller/
│       │   ├── dto/
│       │   ├── entity/
│       │   ├── exception/
│       │   ├── repository/
│       │   ├── security/
│       │   ├── service/
│       │   └── CargotrackingsystemApplication.java
│       └── resources/
│           ├── static/
│           │   └── index.html
│           ├── templates/
│           └── application.properties
├── pom.xml
└── mvnw
```

## 🖥️ Ön Yüz

`index.html` tek sayfalık bir arayüz sunar:

- Genel bakış paneli (istatistikler)
- Takip numarasıyla kargo sorgulama
- Gönderi, müşteri ve taşıyıcı yönetimi (CRUD)

`http://localhost:8080` adresinden erişilir.

## 🚀 Kurulum

```bash
# 1. Depoyu klonla
git clone https://github.com/elffgkce/cargo-tracking-system.git
cd cargo-tracking-system

# 2. PostgreSQL'i Docker ile başlat
docker run --name benim-postgres \
  -e POSTGRES_PASSWORD=1234 \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_DB=cargotracking \
  -p 5432:5432 -d postgres

# 3. Uygulamayı çalıştır
mvn spring-boot:run
```

Uygulama `http://localhost:8080` adresinde çalışır.

## 🔐 Giriş Bilgileri

|Kullanıcı Adı|Şifre   |Rol     |
|-------------|--------|--------|
|admin        |admin123|YÖNETİCİ|
