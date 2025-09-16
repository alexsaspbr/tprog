# 📝 Lista de Exercícios: Java Time API

### **Exercício 1 – Trabalhando com `LocalDate`**
Crie um programa que:
- Obtenha a data atual do sistema.
- Mostre o dia, mês e ano separadamente.
- Adicione **10 dias** à data atual e exiba o resultado.

---

### **Exercício 2 – Usando `LocalTime`**
Escreva um programa que:
- Mostre a hora atual do sistema.
- Adicione **2 horas e 30 minutos** ao horário atual.
- Exiba a hora antes e depois da adição.

---

### **Exercício 3 – Diferença entre datas (`Exercicio3_Period.Period`)**
Crie um programa que:
- Receba duas datas de nascimento diferentes (por exemplo, você pode fixar no código ou pedir ao usuário).
- Calcule a diferença em **anos, meses e dias** entre as duas datas usando `Exercicio3_Period.Period`.
- Exiba o resultado de forma clara, como:  
  `"Diferença: X anos, Y meses e Z dias"`.

---

### **Exercício 4 – Medindo tempo com `Duration`**
Escreva um programa que:
- Capture a hora atual (`LocalTime.now()`).
- Espere o usuário pressionar **ENTER** para continuar.
- Capture novamente a hora e calcule o tempo decorrido em **segundos e nanos** usando `Duration`.

---

### **Exercício 5 – 🚀 Desafio Final: Agendamento com `ZonedDateTime`**
Implemente um programa de agendamento internacional que:
1. Crie um evento para **15 de outubro de 2025 às 14:00** no fuso horário de **São Paulo (America/Sao_Paulo)**.
2. Converta esse horário para os fusos:
    - Nova Iorque (America/New_York)
    - Tóquio (Asia/Tokyo)
    - Londres (Europe/London)
3. Exiba os horários equivalentes nesses fusos de forma clara.  