# IE 343 – Heuristics Design Course Project (ENG)
**Fall 2023–2024**

## Project Title  
**Concert Tour Planning and Setlist Optimization for The Weeknd Using Heuristic Algorithms**

---

## Project Objective

This project aims to design and implement heuristic algorithms in **Java** to plan an efficient concert tour and generate optimal concert setlists for **The Weeknd**.  

The project consists of two main components:

1. **Tour Route Planning** – Determining the most efficient route to visit a set of cities, starting from **New York**, ensuring each city is visited exactly once.
2. **Concert Setlist Optimization** – Selecting the best combination of songs for each city under performance time constraints while maximizing audience popularity.

All implementations strictly follow the provided **GitHub template**, as required by the course rules.

---

## Problem Description

- Each city must be visited **exactly once**.
- Some cities may have specific constraints (order, day, or venue requirements).
- Each concert has a **maximum performance duration**.
- Song popularity varies by city and audience size.
- Song popularity values are given **per audience**.
- Certain venues may request **mandatory songs** to be included.

The challenge is to design heuristic solutions that balance **efficiency**, **correctness**, and **performance quality**.

---

## Algorithms Used

### Traveling Salesman Problem (TSP) – Nearest Neighbor Heuristic

- Used to generate the concert tour route.
- The tour starts from **New York**.
- At each step, the nearest unvisited city is selected.
- The process continues until all cities are visited.

**Time Complexity:**  
\[
O(N^2)
\]

Where:  
- `N` = Number of cities

---

###  Knapsack Algorithm – Setlist Optimization

- Used to select the best song combination for each city.
- Maximizes total popularity under concert duration constraints.
- Implemented using **Bottom-Up Dynamic Programming**.
- Repeated independently for each city.

**Time Complexity:**  
\[
O(W \times N)
\]

Where:  
- `W` = Maximum concert duration  
- `N` = Number of available songs

---

## Results

- An efficient tour route covering all cities was generated using the TSP heuristic.
- Optimal concert setlists were created for each city using the Knapsack algorithm.
- Results demonstrate a balance between computational efficiency and solution quality.

**Figures included in the report:**
- TSP Algorithm Route Visualization  
- TSP Algorithm Output  
- Knapsack Algorithm Output  

---

## Project Structure
```text
2023-24-Fall-Project/
│
├── data/
│ ├── cities.csv
│ ├── songs_data.csv
│ └── ceren_beyda_cities.csv
│
├── pythonfiles/
│ ├── City.py
│ ├── Song.py
│ ├── csv_parser.py
│ ├── knapsack.py
│ ├── tsp.py
│ └── main.py
│
├── src/
│ ├── CSVParser.java
│ ├── City.java
│ ├── Song.java
│ ├── Knapsack.java
│ ├── TSP.java
│ └── Main.java
│
├── dataCreation.ipynb
├── 343 Project.pdf
└── README.md
```

---

## How to Run

1. Clone the repository
2. Compile the Java source files
3. Run the program


## Report

A formal project report has been prepared, covering the following topics:
- Description of the heuristic algorithms
- Time complexity analysis
- Runtime behavior of the algorithms
- Evaluation of the obtained results

## Notes

- Coding from scratch was not permitted; the provided project template was used.
- Heuristic algorithms generate fast and approximate solutions rather than exact optimal solutions.
- The project was completed in accordance with academic integrity rules.
  

---

# IE 343 – Heuristics Design Course Project (Türkçe)
Fall 2023–2024

## Proje Başlığı
Sezgisel Algoritmalar Kullanarak The Weeknd Konser Turu ve Setlist Planlaması

---

## Proje Amacı

Bu proje, IE 343 – Heuristics Design dersi kapsamında sezgisel algoritmaların Java programlama dili kullanılarak uygulanmasını amaçlamaktadır. Projenin temel hedefi, The Weeknd için verimli bir konser turu planı oluşturmak ve her şehir için konser süresi kısıtları altında en uygun şarkı listesini belirlemektir.

Proje iki ana problemden oluşmaktadır:
- Konser turu rotasının belirlenmesi (Travelling Salesman Problem)
- Her şehir için konser setlist optimizasyonu (Knapsack Problemi)

Tüm çözümler ders kapsamında sağlanan GitHub şablonu kullanılarak Java dilinde geliştirilmiştir.

---

## Problem Tanımı

- Tur New York şehrinden başlamaktadır.
- Her şehir yalnızca bir kez ziyaret edilmelidir.
- Bazı şehirlerin ziyaret sırası veya gününe ilişkin kısıtlar bulunabilir.
- Her konserin maksimum süresi vardır.
- Şarkıların popülaritesi şehir ve seyirciye göre değişmektedir.
- Popülarite değerleri seyirci başına verilmiştir.
- Bazı konser salonları belirli şarkıların çalınmasını zorunlu kılabilir.

Amaç, bu kısıtlar altında doğru ve verimli sezgisel algoritmalar geliştirmektir.

---

## Kullanılan Algoritmalar

### Travelling Salesman Problem (TSP)

Konser turu rotası, En Yakın Komşu (Nearest Neighbor) sezgisel algoritması kullanılarak oluşturulmuştur. Algoritma New York şehrinden başlar ve her adımda henüz ziyaret edilmemiş en yakın şehri seçerek turu tamamlar.

Zaman karmaşıklığı:
O(N²)

N: Şehir sayısı

---

### Knapsack Algoritması

Her şehir için konser setlisti, dinamik programlama tabanlı Knapsack algoritması kullanılarak oluşturulmuştur. Algoritma, konser süresi kısıtı altında toplam popülariteyi maksimize edecek şarkı kombinasyonunu belirler. Bu işlem her şehir için ayrı ayrı uygulanmıştır.

Zaman karmaşıklığı:
O(W × N)

W: Maksimum konser süresi  
N: Şarkı sayısı

---

## Sonuçlar

- TSP algoritması ile tüm şehirleri kapsayan verimli bir konser turu rotası elde edilmiştir.
- Knapsack algoritması ile her şehir için en yüksek popülariteyi sağlayan setlistler oluşturulmuştur.
- Algoritmalar doğruluk ve çalışma süresi açısından başarılı sonuçlar üretmiştir.

Sonuçlara ait görseller proje raporunda yer almaktadır.

---

## Proje Dosya Yapısı

```text
2023-24-Fall-Project/
│
├── data/
│ ├── cities.csv
│ ├── songs_data.csv
│ └── ceren_beyda_cities.csv
│
├── pythonfiles/
│ ├── City.py
│ ├── Song.py
│ ├── csv_parser.py
│ ├── knapsack.py
│ ├── tsp.py
│ └── main.py
│
├── src/
│ ├── CSVParser.java
│ ├── City.java
│ ├── Song.java
│ ├── Knapsack.java
│ ├── TSP.java
│ └── Main.java
│
├── dataCreation.ipynb
├── 343 Project.pdf
└── README.md
```

---

## Çalıştırma Adımları

1. Repository’yi klonlayın
2. Java kaynak dosyalarını derleyin
3. Programı çalıştırın


## Rapor
Proje kapsamında hazırlanan raporda aşağıdaki konular yer almaktadır:
- Kullanılan sezgisel algoritmalar
- Zaman karmaşıklığı analizleri
- Algoritmaların çalışma mantığı
- Elde edilen sonuçların değerlendirilmesi


## Notlar

- Kodlar sıfırdan yazılmamış, ders kapsamında sağlanan şablon kullanılmıştır.
- Sezgisel algoritmalar kesin optimal çözüm yerine hızlı ve yaklaşık çözümler üretmektedir.










