function viewDiv(className)
{
    alert(className);
    document.getElementsByClassName(className.toString())[0].style.display = "block";
}

function notViewDiv(className, backName)
{
    document.getElementsByClassName(className)[0].style.display = "none";
    document.getElementsByClassName(backName)[0].style.display = "none";
}


