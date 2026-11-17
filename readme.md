# Программ хангамжийн чанарын баталгаа ба туршилт - Лаб 10
B232270105 - Б.Хан-Эрдэнэ
<hr>

## A - gcd

Замын тэмдэглэгээ 15T/F нь while (y != 0)-ийн true/false салаа. G1 нь gcdWithZeroSecondArgument, G2 нь gcdWithOneIteration, G3 нь gcdWithTwoIterations тест.

| Хувьсагч | Def мөр | Use мөр | Төрөл | Def-clear зам | Тест | Хамрагдсан |
|---|---:|---:|---|---|---|---|
| x | 13 | 16 | c-use | 13→15T→16 | G2, G3 | Тийм |
| x | 13 | 20 | c-use | 13→15F→20 | G1 | Тийм |
| x | 17 | 16 | c-use | 17→18→15T→16 | G2, G3 | Тийм |
| x | 17 | 20 | c-use | 17→18→15F→20 | G2, G3 | Тийм |
| y | 13 | 15 | p-use | 13→15 | G2/G3 (15T), G1 (15F) | Тийм |
| y | 13 | 16 | c-use | 13→15T→16 | G2, G3 | Тийм |
| y | 13 | 17 | c-use | 13→15T→16→17 | G2, G3 | Тийм |
| y | 18 | 15 | p-use | 18→15 | G2/G3 | Тийм |
| y | 18 | 16 | c-use | 18→15T→16 | G2, G3 | Тийм |
| y | 18 | 17 | c-use | 18→15T→16→17 | G2, G3 | Тийм |
| tmp | 16 | 18 | c-use | 16→17→18 | G2, G3 | Тийм |

G1 нь давталтгүй тул x-ийн эхний тодорхойлолт (13) return (20)-д хүрдэг хосыг ганцаараа хамарна. Давталт ядаж нэг удаа ажиллах бол үүнээс бусад бүх хосууд давталт шаардана. 2+ давталтад 18→15T зам туулсан хосууд багтана (хүснэгтийн 3, 9, 10-р мөрүүд)

gcd(12, 8) нь хоёр удаа давтана.

## B - bonus
### B1
[Зураг](cfg.png)

### B2

| Мөр | Def | Use |
|:---:|:---:|:---|
| 31 | `attendance`, `threshold` (параметр) | — |
| 32 | — | `attendance` p-use; short circuit `threshold` p-use |
| 35 | `present` | — |
| 36 | `streak` | — |
| 37 | `best` | — |
| 38 | `a` (элемент бүрд def) | `attendance` p-use: дараагийн элемент байгаа/байхгүй |
| 39 | — | `a` p-use |
| 40 | `present` | өмнөх `present` c-use |
| 41 | `streak` | өмнөх `streak` c-use |
| 42 | — | `streak`, `best` p-use |
| 43 | `best` | `streak` c-use |
| 46 | `streak` | — |
| 49 | `score` | — |
| 50 | — | `present`, `threshold` p-use |
| 51 | `score` | — |
| 53 | — | `best` p-use |
| 54 | `score` | өмнөх `score` c-use |
| 56 | — | `score` c-use |

### B3

Тэмдэглэгээ: B1=`emptyAttendanceDoesNotMeetPositiveThreshold`; B2=`absenceResetsStreakBeforeAttendance`; B3=`fiveConsecutiveDaysEarnStreakReward`; B4=`zeroThresholdRewardsEmptyAttendance`; B5=`mixedAttendanceWithBothRewards`; B6=`shorterRunsDoNotEarnStreakReward`; B7=`nullAttendanceIsRejected`; B8=`negativeThresholdIsRejected`.

| Хувьсагч | Def мөр | Use мөр | Төрөл | Def-clear зам / салаа | Тест ID | Хамрагдсан |
|---|---:|---:|---|---|---|---|
| attendance | 31 | 32 | p-use | null T/F (баруун тал зөвхөн null биш үед үнэлэгдэнэ) | B7, B1, B8 | Тийм |
| attendance | 31 | 38 | p-use | элемент байна/байхгүй | B2, B1 | Тийм |
| threshold | 31 | 32 | p-use | null биш оролт дээр `<0` T/F | B8, B1 | Тийм |
| threshold | 31 | 50 | p-use | 35→38→…→50, `present >= threshold` T/F | B2/B4, B1/B3/B6 | Тийм |
| present | 35 | 40 | c-use | 35→38T→39T→40 | B2 | Тийм |
| present | 35 | 50 | p-use | 35→38F→49→50 | B1 | Тийм |
| present | 40 | 40 | c-use | 40→…→дараагийн 40 | B3, B5 | Тийм |
| present | 40 | 50 | p-use | 40→…→38F→50 | B2, B3 | Тийм |
| a | 38 | 39 (T/F) | p-use | тухайн элемент эерэг/эерэг биш | B2 | Тийм |
| streak | 36 | 41 | c-use | 36→38T→39T→41 | B3 | Тийм |
| streak | 41 | 41 | c-use | эерэг дараалсан элементүүдийн давталтаар | B3, B5 | Тийм |
| streak | 41 | 42 | p-use | 41→42; `streak > best` T/F | B3 (T), B6 (F) | Тийм |
| streak | 46 | 41 | c-use | 46→38T→39T→41 | B2 | Тийм |
| best | 37 | 42 | p-use | 37→…→42 | B2, B3 | Тийм |
| best | 37 | 53 | p-use | давталтгүй: 37→38F→…→53 | B1 | Тийм |
| best | 43 | 42 | p-use | 43→дараагийн эерэг элемент→42, T/F | B3 (T), B6 (F) | Тийм |
| best | 43 | 53 | p-use | 43→давталтын төгсгөл→53 | B2, B3, B6 | Тийм |
| score | 49 | 54 | c-use | 49→50F→53T→54 | B3 | Тийм |
| score | 49 | 56 | c-use | 49→50F→53F→56 | B1 | Тийм |
| score | 51 | 54 | c-use | 51→53T→54 | B5 | Тийм |
| score | 51 | 56 | c-use | 51→53F→56 | B2 | Тийм |
| score | 54 | 56 | c-use | 54→56 | B3, B5 | Тийм |

**Kill ба биелэшгүй хосууд.** Мөр 46-ын `streak=0` нь 36 болон өмнөх 41-ийн def-ийг kill хийнэ. Гэхдээ 46-аас 42 руу def-clear зам байхгүй: дараагийн элемент байгаа бол 41-ийн уншилт, дахин def 42-оос өмнө орно; тасалбал 46 дахин def болно. Иймд `streak(36/46)->42` нь DU хос биш. Мөн эерэг өдрийн дараах `streak(41)->42`-ын хооронд 41 дараагийн эерэг дээр дахин def болно, харин таслалт 42-ыг алгасч 46-д хүргэнэ. `present(35)->50` зөвхөн эерэг өдөргүй замаар боломжтой; эерэг өдөр байвал 40 def нь 35-ыг kill хийнэ. `attendance` null үед `||` short circuit-с болж `threshold < 0` үнэлэгдэхгүй; тиймээс attendance-ийн эхний нөхцөлийн null-T болон threshold-ийн нөхцөлийн T-г нэг замаар авах боломжгүй.

### B4-B5

All-defs шатанд хамгийн багадаа **3 bonus тест** хэрэгтэй: `score`-ийн 49, 51, 54-р мөрийн def-үүд нэг гүйцэтгэлд хоорондоо дараалан kill хийгдэх тул тус бүрийг return/use-д хүргэх тусдаа зам шаардана. B1 нь 49→56, B2 нь 51→56, B3 нь 54→56 хосыг хамарна. Эдгээрт G1–G3 нэмэгдэж `mvn verify` нийт **6 тест** ажиллуулсан.

| Гүйлт | `Tests run` | JaCoCo Branch | JaCoCo Line |
|---|---:|---:|---:|
| All-defs (`results/mvn-verify-alldefs.txt`, `jacoco-alldefs.csv`) | 6 | 13/16 хамрагдсан, 3 missed | 22 covered, 2 missed |
| Эцсийн all-DU-pairs (`results/mvn-verify-final.txt`, `jacoco-final.csv`) | 11 | 16/16 хамрагдсан, 0 missed | 24 covered, 1 missed |   

Эцсийн ганц мөрийн miss нь зааварт дурдсан 7-р мөрийн далд constructor. Эхний all-defs гүйлт 100% branch биш (`13/16`) хэдий ч бүх def-ийг use-д хүргэсэн. Харин зөвхөн branch 100% нь DU-г батлахгүй: `gcd(12,8)` нь while-ийн T ба F салааг хоёуланг хамарна, гэхдээ `x`-ийн параметрийн def (13) return (20)-д хүрэх хосыг хамрахгүй; энэ хосод `gcd(7,0)` хэрэгтэй. JaCoCo бол салбарын хэмжүүр, DU хүснэгтийг орлохгүй.


## C. Fault seeding

Мутацийн туршилт бүрийн дараа эх файлыг байтаар нь анхны хувилбараар сэргээсэн. `results/mvn-test-*.txt` нь тус бүрийн бүтэн гаралт.

| Мутаци | Үр дүн | Ажиглагдсан тест / үр дүн |
|---|---|---|
| M1 — 41-р мөрийн `streak = streak + 1`-ийг арилгах | Илэрсэн | `fiveConsecutiveDaysEarnStreakReward`: expected 3, was 0; `mixedAttendanceWithBothRewards`: expected 8, was 5. |
| M2 — 43-р мөрийн `best = streak`-ийг `best = present` болгох | Илэрсэн | `shorterRunsDoNotEarnStreakReward`: expected 0, was 3. `[1,1,0,1,1,1]`-д хамгийн урт цуваа 3, нийт ирц 5; алдаатай def нь 5 болгож, байхгүй 3 онооны урамшуулал олгосон. |
| M3 — ашиглагдаагүй `int total = present + best;` def нэмэх | Тест илрүүлээгүй | 11 тест бүгд амжилттай. `total` үр дүнд нөлөөлөх use-гүй dead definition тул runtime тест хариу өөрчлөхгүй. |

M3-ийг илрүүлэхэд статик анализ/IDE-ийн unused-local буюу dead-store inspection тохирно; `javac`-ийн энгийн compile болон JUnit үүнийг заавал анхааруулахгүй. Энэ орчинд IDE-ийн Problems самбарын бодит анхааруулгыг авч хавсаргаагүй бөгөөд төсөлд нэмэлт статик анализатор тохируулаагүй.

