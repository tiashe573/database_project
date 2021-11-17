function createData(){
    var txtBox1 = document.createElement('div');
    txtBox1.innerHTML = document.getElementById("room_num").value;

    var txtBox2 = document.createElement('div');
    txtBox2.innerHTML = document.getElementById("building").value;

    var txtBox3 = document.createElement('div');
    txtBox3.innerHTML = document.getElementById("floor").value;

    var txtBox4 = document.createElement('div');
    txtBox4.innerHTML = document.getElementById("avatime").value;

    var txtBox5 = document.createElement('div');
    txtBox5.innerHTML = document.getElementById("avadate").value;

    var txtBox6 = document.createElement('div');
    txtBox6.innerHTML = document.getElementById("period").value;

    var txtBox7 = document.createElement('div');
    txtBox7.innerHTML = document.getElementById("roomcharge").value;

    var txtBox8 = document.createElement('div');
    txtBox8.innerHTML = document.getElementById("capacity").value;

    var button9 = document.createElement('div');
    button9.innerHTML = " <button type='Delete'>Make Reservation</button>";

    var button10 = document.createElement('div');
    var a = "pop.html";
    button10.innerHTML = "<input type='button' value='Delete' onclick='poptastic(\"pop.html\");'/>"

    document.getElementById("newBox1").appendChild(txtBox1);
    document.getElementById("newBox2").appendChild(txtBox2);
    document.getElementById("newBox3").appendChild(txtBox3);
    document.getElementById("newBox4").appendChild(txtBox4);
    document.getElementById("newBox5").appendChild(txtBox5);
    document.getElementById("newBox6").appendChild(txtBox6);
    document.getElementById("newBox7").appendChild(txtBox7);
    document.getElementById("newBox8").appendChild(txtBox8);
    document.getElementById("newBox9").appendChild(button9);
    document.getElementById("newBox10").appendChild(button10);
}

function saveText(){
    var txtBox8 = document.createElement('div');
    txtBox8.innerHTML = document.getElementById('newBox1').lastChild.defaultValue;
    document.getElementById("newBox1").removeChild(document.getElementById("newBox1").lastChild);
    document.getElementById("newBox1").appendChild(txtBox8);
}