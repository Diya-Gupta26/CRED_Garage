package com.example.profileactivity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.CreditScore
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        TopBar()
        Spacer(Modifier.height(30.dp))
        ProfileHeader()
        Spacer(Modifier.height(20.dp))
        CredGarageCard()
        Spacer(Modifier.height(30.dp))
        InfoRow(
            label = "credit score",
            value = "900",
            subtext = "REFRESH AVAILABLE",
            subtextColor = Color.Green,
            leadingIcon = painterResource(R.drawable.credit)
        )
        HorizontalDivider(thickness = 1.dp, color = Color.White.copy(alpha = 0.2f))

        InfoRow("lifetime cashback",
            "₹10", leadingIcon = painterResource(R.drawable.cashback)
        )
        HorizontalDivider(thickness = 1.dp, color = Color.White.copy(alpha = 0.2f))

        InfoRow("bank balance",
            "check", leadingIcon = painterResource(R.drawable.balance)
        )

        Spacer(Modifier.height(20.dp))
        RewardsSection()
        Spacer(Modifier.height(20.dp))
        transactions()

    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Profile", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(
                imageVector = Icons.Default.ChatBubbleOutline,
                contentDescription = "Support",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text("Support", color = Color.Gray, fontSize = 12.sp)
        }
    }
}


@Composable
    fun ProfileHeader(){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
            , horizontalArrangement = Arrangement.SpaceBetween)
        {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Profile Image",
                    modifier = Modifier.size(60.dp).clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Diya Gupta", color = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("member since Dec, 2020", color = Color.Gray, fontSize = 12.sp)
                }
            }
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit Profile",
                tint= Color.White
            )
        }

    }
@Composable
    fun CredGarageCard(){
      Card (
          modifier = Modifier.fillMaxWidth()
              .padding(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
          elevation = CardDefaults.cardElevation(4.dp)
      ){
          Row(
              modifier = Modifier.fillMaxWidth().padding(16.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
          ){
                Row (verticalAlignment = Alignment.CenterVertically)
                {
                    Icon(
                        imageVector = Icons.Default.DirectionsCar,
                        contentDescription = "Car Icon",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            "get to know your vehicles, inside out",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                         Row(verticalAlignment = Alignment.CenterVertically){
                             Text(
                                 "CRED garage", color = Color.White,
                                 fontWeight = FontWeight.Bold
                             )
                             Spacer(modifier = Modifier.width(4.dp))
                             Icon(
                                 imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                 contentDescription = "Go",
                                 tint = Color.White
                             )
                         }
                    }

                }
          }
      }
    }

@Composable
fun InfoRow(
    label: String,
    value: String,
    subtext: String? = null,
    subtextColor: Color = Color.Gray ,
    leadingIcon: Painter? = null

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (leadingIcon != null) {
                Icon(
                    painter = leadingIcon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(20.dp)
                )
            }
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(label, color = Color.Gray, fontSize = 14.sp)

                    if (subtext != null) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("•", color = Color.Green, fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(subtext, color = subtextColor, fontSize = 12.sp)
                    }
                }
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(value, color = Color.White, fontSize = 16.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Arrow",
                tint = Color.White
            )
        }
    }
}
@Composable
fun RewardsSection(){
    Text("YOUR REWARDS & BENEFITS", color = Color.Gray)
    Spacer(Modifier.height(15.dp))
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
       Column {
           Text("cashback balance", color = Color.White, fontSize = 14.sp)
           Spacer(modifier = Modifier.height(4.dp))
           Text("₹0", color = Color.Gray, fontSize = 12.sp)
       }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Arrow",
            tint = Color.White
        )
    }
    HorizontalDivider(thickness = 1.dp, color = Color.White.copy(alpha = 0.2f))

    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text("coins", color = Color.White, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text("45,82,654", color = Color.Gray, fontSize = 12.sp)
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Arrow",
            tint = Color.White
        )
    }
    HorizontalDivider(thickness = 1.dp, color = Color.White.copy(alpha = 0.2f))

    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text("win upto 1000 Rs", color = Color.White, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text("refer and earn", color = Color.Gray, fontSize = 12.sp)
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Arrow",
            tint = Color.White
        )
    }
}
@Composable
fun transactions(){
    Text("Transactions & Support", color = Color.Gray)
    Spacer(Modifier.height(8.dp))
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text("all transactions", color = Color.White, fontSize = 14.sp)
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Arrow",
            tint = Color.White
        )
    }
    HorizontalDivider(thickness = 1.dp, color = Color.White.copy(alpha = 0.2f))
}



@Preview(showBackground=true)
@Composable
fun ProfileReview(){
    ProfileScreen()
}