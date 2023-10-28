package com.guercifzone.ui_controls_android.TextViews;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;
import com.guercifzone.ui_controls_android.TextViews.fontlib.CustomFontConfiguration;
import com.guercifzone.ui_controls_android.TextViews.fontlib.CustomFontEngine;

import java.util.HashMap;

public class Activity_Autocomplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
        Countreies);
AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.edit);
textView.setAdapter(adapter);

    }
    static final String[] Countreies = new String[]{
            "أثيوبيا","أذربيجان","أرمينيا",  "أروبا","إريتريا","إسبانيا","أستراليا",
            "استونيا",
            "أفغانستان",
            "إقليم المحيط الهندي البريطاني",
            "الاتحاد الروسي",
            "الأراضي الفرنسية الجنوبية والقارة القطبية الجنوبية",
            "الأرجنتين",
            "الأردن",
            "الإكوادور",
            "الإمارات العربية المتحدة",
            "ألبانيا",
            "البحرين",
            "البرازيل",
            "البرتغال",
            "البوسنة والهرسك",
            "الجابون",
            "الجبل الأسود",
            "الجزائر",
            "الجمهورية التشيكية",
            "الدنمرك",
            "الرأس الأخضر",
            "السلفادور",
            "السنغال",
            "السودان",
            "السويد",
            "الصحراء الغربية",
            "الصومال",
            "الصين",
            "العراق",
            "الفلبين",
            "القارة القطبية الجنوبية",
            "الكاميرون",
            "الكرسي الرسولي (الفاتيكان)",
            "الكويت",
            "المارتينيك",
            "ألمانيا",
            "المجر",
            "المكسيك",
            "المملكة العربية السعودية",
            "المملكة المتحدة",
            "النرويج",
            "النمسا",
            "النيجر",
            "اليابان",
            "اليمن",
            "اليونان",
            "انتيغوا وبربودا",
            "أنجولا",
            "أندورا",
            "إندونيسيا",
            "أنغيلا",
            "أوروجواي",
            "أوزبكستان",
            "أوغندا",
            "أوكرانيا",
            "إيران",
            "ايرلندا",
            "أيسلندا",
            "إيطاليا",
            "بابوا غينيا الجديدة",
            "باراغواي",
            "باكستان",
            "بالاو",
            "بربادوس",
            "برمودا",
            "بروناي دار السلام",
            "بلجيكا",
            "بلغاريا",
            "بليز",
            "بنغلاديش",
            "بنما",
            "بنين",
            "بوتان",
            "بوتسوانا",
            "بوركينا فاسو",
            "بورما",
            "بوروندي",
            "بولندا",
            "بوليفيا",
            "بولينيزيا الفرنسية",
            "بونير",
            "بويرتو ريكو",
            "بيرو",
            "تايلاند",
            "تايوان",
            "تركمانستان",
            "تركيا",
            "ترينيداد وتوباجو",
            "تشاد",
            "تشيلي",
            "تنزانيا",
            "توجو",
            "توفالو",
            "توكيلاو",
            "تونجا",
            "تونس",
            "تيمور الشرقية",
            "جامايكا",
            "جامبيا",
            "جبل طارق",
            "جرينادا",
            "جرينلند",
            "جزر الانتيل الهولندية",
            "جزر البهاما",
            "جزر القمر",
            "جزر المالديف",
            "جزر الولايات المتحدة البعيدة الصغيرة",
            "جزر بيتكيرن",
            "جزر تركس وكايكوس",
            "جزر سليمان",
            "جزر فارو",
            "جزر فوكلاند (مالفيناس)",
            "جزر فيرجن",
            "جزر فيرجن البريطانية",
            "جزر كايمان",
            "جزر كوك",
            "جزر كوكوس (كيلينغ)",
            "جزر مارشال",
            "جزر ماريانا الشمالية",
            "جزيرة آيل أوف مان",
            "جزيرة بوفيت",
            "جزيرة كريسماس",
            "جزيرة مايوت",
            "جزيرة نورفولك",
            "جزيرة هيرد وجزر ماكدونالد",
            "جمهورية أفريقيا الوسطى",
            "جمهورية الدومينيكان",
            "جمهورية الكونغو",
            "جمهورية الكونغو الديمقراطية",
            "جنوب أفريقيا",
            "جنوب السودان",
            "جواتيمالا",
            "جواديلوب",
            "جوام",
            "جورجيا",
            "جورجيا الجنوبية وجزر ساندويتش الجنوبية",
            "جيانا الفرنسية",
            "جيبوتي",
            "جيرسي",
            "جيرنسي",
            "دومينيكا",
            "رواندا",
            "روسيا البيضاء",
            "رومانيا",
            "رينيون",
            "زامبيا",
            "زيمبابوي",
            "ساموا",
            "ساموا الأمريكية",
            "سان بيار وميكلون",
            "سان مارينو",
            "سانت بارتيليمي",
            "سانت تومي وبرينسبل",
            "سانت فنسنت وغرينادين",
            "سانت كيتس ونيفيس",
            "سانت لوسيا",
            "سانت مارتن",
            "سانت هيلانة",
            "سريلانكا",
            "سفالبارد",
            "سلطنة عمان",
            "سلوفاكيا",
            "سلوفينيا",
            "سنغافورة",
            "سوازيلاند",
            "سوريا",
            "سورينام",
            "سويسرا",
            "سيراليون",
            "سيشيل",
            "سينت مارتن",
            "صربيا",
            "طاجيكستان",
            "غانا",
            "غيانا",
            "غينيا",
            "غينيا الاستوائية",
            "غينيا بيساو",
            "فانواتو",
            "فرنسا",
            "فلسطين",
            "فنزويلا",
            "فنلندا",
            "فيتنام",
            "فيجي",
            "قبرص",
            "قطر",
            "قيرغيزستان",
            "كازاخستان",
            "كاليدونيا الجديدة",
            "كرواتيا",
            "كمبوديا",
            "كندا",
            "كوت ديفوار",
            "كوراكاو",
            "كوريا الجنوبية",
            "كوريا الشمالية",
            "كوستاريكا",
            "كوسوفو",
            "كولومبيا",
            "كيريباتي",
            "كينيا",
            "لاتفيا",
            "لاوس",
            "لبنان",
            "لوكسمبورغ",
            "ليبيريا",
            "ليتوانيا",
            "ليختنشتاين",
            "ليسوتو",
            "ماكاو",
            "مالاوي",
            "مالطا",
            "مالي",
            "ماليزيا",
            "مدغشقر",
            "مصر",
            "مغربي",
            "مقدونيا",
            "منغوليا",
            "موريتانيا",
            "موريشيوس",
            "موزمبيق",
            "مولدوفيا",
            "موناكو",
            "مونتسيرات",
            "ناميبيا",
            "ناورو",
            "نيبال",
            "نيجيريا",
            "نيكاراغوا",
            "نيوزيلندا",
            "نيوي",
            "هايتي",
            "هندوراس",
            "هولندا",
            "هونج كونج",
            "واليس وفوتونا",
    };

}