package project.excompose

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import project.excompose.ui.theme.ExComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                ListItem(
                    name = "Психоло́гия",
                    info = "научная дисциплина, изучающая закономерности возникновения, развития и функционирования психики и психической деятельности человека и групп людей"
                )
                ListItem(
                    name = "Агрессия",
                    info = "индивидуальное или групповое поведение, направленное на нанесение физического или психологического ущерба другому человеку или социальной группе."
                )
                ListItem(
                    name = "Внутренняя установка",
                    info = "субъективное восприятие личностью своего статуса в группе."
                )
                ListItem(
                    name = "Катарсис",
                    info = "термин введен Аристотелем как душевная разрядка, испытываемая зрителем в процессе сопереживания или освобождение от отрицательных чувств и мыслей под воздействием произведений искусства, музыки, соблюдения ритуалов."
                )
                ListItem(
                    name = "Роль",
                    info = "нормативно заданный или коллективно одобряемый образец поведения личности в группе."
                )
                ListItem(
                    name = "Трансакция",
                    info = "единица взаимодействия партнеров по общению, предполагающая выбор определенной позиции (Родитель, Взрослый, Ребенок)."
                )
                ListItem(
                    name = "Установка",
                    info = "готовность, предрасположенность субъекта к определенной ситуации, определенному поведению, действию."
                )
                ListItem(
                    name = "Проекция",
                    info = "осознанный или бессознательный перенос субъектом собственных мыслей, побуждений и качеств на других."
                )
                ListItem(
                    name = "Посредник",
                    info = "третья сторона в переговорном процессе по поводу конфликта, обеспечивающая конструктивное обсуждение проблемы."
                )
                ListItem(
                    name = "Медиатор",
                    info = "профессиональный посредник в переговорах по разрешению конфликта."
                )
            }

        }
    }
}


@Composable
private fun ListItem(name: String, info: String) {
    val counter = remember {
        mutableStateOf(0)
    }
    val color = remember {
        mutableStateOf(Color.Gray)
    }
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                when(counter.value++){
                    4-> color.value = Color.Cyan
                }

            }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount -> }
                TODO()
            },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Box(
            modifier = Modifier.background(color.value), contentAlignment = Alignment.Center
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.emoticon),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column {
                    Text(text = "$name:", style = TextStyle(color = Color.White, fontSize = 17.sp))
                    Text(text = info, textAlign = TextAlign.Justify,style = TextStyle(color = Color.White, fontSize = 15.sp))
                    Text(text = "Повторено: ${counter.value} раз",style = TextStyle(color = Color.White))
                }

            }

        }
    }
}