package com.coronaapp.Object

import com.coronaapp.R
import com.coronaapp.model.Vaccine.jenisVaksinDatamodel

object VaccineData {

    private val image = arrayOf(
        R.drawable.ikon_vaksin_sinovac,
        R.drawable.astrazeneca,
        R.drawable.sinoparm,
        R.drawable.ikon_vaksin_moderna,
        R.drawable.ikon_vaksin_pfizer,
        R.drawable.novavax,
        R.drawable.ikon_vaksin_sputnik,
        R.drawable.janssen,
        R.drawable.codencia,
        R.drawable.zinifax
    )

    private val VaccineName = arrayOf(
        "Vaksin Sinovac",
        "Vaksin AstraZeneca",
        "Vaksin Sinopharm",
        "Vaksin Moderna",
        "Vaksin Pfizer",
        "Vaksin Novavax",
        "Vaksin Sputnik-V",
        "Vaksin Janssen",
        "Vaksin Convidencia",
        "Vaksin Zifivax"
    )

    private val VaccinePlatform = arrayOf(
        "Virus dimatikan",
        "Viral vector",
        "Virus dimatikan",
        "mRNA",
        "RNA-based",
        "Protein sub-unit",
        "Non-replicating viral vector",
        "Non-replicating viral vector",
        "Non-replicating viral vector",
        "Rekombinan protein sub-unit"
    )

    private val Dossage = arrayOf(
        "2x (0,5 ml/dosis)",
        "2 x (0,5 ml/dosis)",
        "2 x (0,5 ml/dosis)",
        "2 x (0,5 ml/dosis)",
        "2 x (0,3 ml/dosis)",
        "2 x (0,5 ml/dosis)",
        "2 x (0,5 ml/dosis)",
        "dosis tunggal (0,5 ml/dosis)",
        "dosis tunggal (0,5 ml/dosis)",
        "3 x (0,5 ml/dosis)"
    )

    private val SpaceDossage = arrayOf(
        "28 hari",
        "12 minggu",
        "21 hari",
        "28 hari",
        "21-28 hari",
        "21 hari",
        "3 minggu",
        "-",
        "-",
        "1 bulan dari suntik pertama"
    )

    private val Effeciency = arrayOf(
        "Berdasarkan informasi dari produsen, vaksin CoronaVac terbukti 51% efektif melawan infeksi simtomatik.Vaksin ini juga terbukti 100% efektif terhadap penyakit parah dan yang perlu perawatan rumah sakit.Vaksin COVID-19 yang banyak digunakan dan setidaknya memiliki efektivitas 50% yang akan membantu mengendalikan pandemi",
        "Berdasarkan data dari produsen, vaksin Astrazeneca-Oxford, atau AZD1222, terbukti 63% efektif dalam uji klinis skala besar berkelanjutan.Vaksin COVID-19 yang banyak digunakan dan paling tidak 50% efektif dapat membantu mengendalikan pandemi",
        "Berdasarkan informasi dari produsen, vaksin Sinopharm BIBP terbukti 79% efektif dalam uji klinis skala besar berkelanjutan.Vaksin COVID-19 yang banyak digunakan dan setidaknya memiliki efektivitas 50% dapat membantu mengendalikan pandemi.",
        "Berdasarkan data dari produsen, vaksin Moderna, atau mRNA-1273, terbukti 94,1% efektif dalam uji klinis skala besar berkelanjutan.Vaksin COVID-19 yang banyak digunakan dan paling tidak 50% efektif dapat membantu mengendalikan pandemi.",
        "Berdasarkan data dari produsen, vaksin Pfizer-BioNTech, atau BNT162b2, terbukti 95% efektif dalam uji klinis skala besar berkelanjutan.Vaksin COVID-19 yang banyak digunakan dan paling tidak 50% efektif dapat membantu mengendalikan pandemi.",
        "Novavax Inc mengklaim bahwa vaksin COVID-19-nya memiliki efektivitas lebih dari 90% dalam uji klinis tahap akhir di AS. Efektivitas tersebut termasuk terhadap berbagai macam varian virus corona yang mengkhawatirkan akhir-akhir ini.",
        "Hasil terakhir menunjukkan bahwa efektivitasnya sekitar 83 persen",
        "Berdasarkan informasi dari produsen, vaksin Johnson & Johnson, atau Ad26.COV2.S, terbukti 66,9% efektif dalam uji klinis skala besar berkelanjutan.Vaksin COVID-19 yang banyak digunakan dan setidaknya memiliki efektivitas 50% dapat membantu mengendalikan pandemi.",
        "-",
        "berdasarkan pengukuran antibodi netralisasi dengan seroconversion rate dan Geometric Mean Titer (GMT) adalah 83,22% dan 102,5, serta pengukuran Receptor-Binding Domain (RBD) binding protein antibody dengan seroconversion rate dan GMT adalah 99,31% dan 1782,26."
    )

    private val impact = arrayOf(
        "Efek samping vaksin Sinovac dengan derajat berat seperti sakit kepala, gangguan di kulit atau diare yang dilaporkan hanya sekitar 0,1 sampai dengan 1 persen.",
        "Efek samping vaksin Astrazeneca bersifat ringan dan sedang. Berikut efek samping vaksin AstraZeneca: nyeri, kemerahan, gatal, pembengkakan, kelelahan, sakit kepala, meriang, dan mual.",
        "Efek samping vaksin Sinopharm yang banyak dijumpai adalah efek samping lokal yang ringan. Di antaranya seperti berikut: nyeri atau kemerahan di tempat suntikan, efek samping sistemik berupa sakit kepala, nyeri otot, kelelahan, diare, dan batuk.",
        "Beberapa efek samping yang paling sering dirasakan sebagai berikut: nyeri (di tempat suntikan), kelelahan, nyeri otot, nyeri sendi, dan pusing. Sementara itu, potensi gejala umum atau moderat yang muncul dapat berupa lemas, sakit kepala, menggigil, demam, dan mual.",
        "Untuk efek samping pasca-vaksinasi, sebagian besar cenderung bersifat ringan. Berikut beberapa efek samping vaksin Pfizer yang umum dilaporkan: nyeri badan di tempat bekas suntikan, kelelahan, nyeri kepala, nyeri otot, nyeri sendi, dan demam.",
        "-",
        "Efek samping dari penggunaan Sputnik v merupakan efek samping dengan tingkat keparahan ringan atau sedang seperti flu yang ditandai dengan demam, menggigil, nyeri sendi, nyeri otot, badan lemas, ketidaknyamanan, sakit kepala, hipertermia, atau reaksi lokal pada lokasi injeksi.",
        "Efek samping dari penggunaan Sputnik v merupakan efek samping dengan tingkat keparahan ringan atau sedang seperti flu yang ditandai dengan demam, menggigil, nyeri sendi, nyeri otot, badan lemas, ketidaknyamanan, sakit kepala, hipertermia, atau reaksi lokal pada lokasi injeksi. ",
        "KIPI dari pemberian vaksin Convidecia juga menunjukkan reaksi ringan hingga sedang. KIPI lokal yang umum terjadi, antara lain adalah nyeri, kemerahan, dan pembengkakan, serta KIPI sistemik yang umum terjadi adalah sakit kepala, rasa lelah, nyeri otot, mengantuk, mual, muntah, demam dan diare.",
        "Efek samping pemberian vaksin Zifivax antara lain timbul nyeri pada tempat suntikan, sakit kepala, kelelahan, demam, nyeri otot (myalgia), batuk, mual (nausea), diare dengan tingkat keparahan grade 1 dan 2. "
    )

    val listData: ArrayList<jenisVaksinDatamodel>
        get() {
            val list = arrayListOf<jenisVaksinDatamodel>()
            for (i in image.indices) {
                val jenisvaksinDatamodel = jenisVaksinDatamodel()
                jenisvaksinDatamodel.VaccineImage = image[i]
                jenisvaksinDatamodel.VaccineName = VaccineName[i]
                jenisvaksinDatamodel.VaccinePlatform = VaccinePlatform[i]
                jenisvaksinDatamodel.VaccineDossage = Dossage[i]
                jenisvaksinDatamodel.VaccineDossageSpace = SpaceDossage[i]
                jenisvaksinDatamodel.VaccineEfeciency = Effeciency[i]
                jenisvaksinDatamodel.VaccineImpact = impact[i]
                list.add(jenisvaksinDatamodel)
            }
            return list
        }
}