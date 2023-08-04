// 데이터
// 파일이름과 음식이름을 빈 칸을 띄고 하나로 관리
let foods = [
    "burger 햄버거",
    "cake 케이크",
    "sandwich 샌드위치",
    "steak 스테이크"
];


// init
// 처음에 thumbnail 표시
function init(){
    let html = ""; // 빈 문자열
    let imgThumb = document.querySelector(".img-thumb");

    for(let i=0; i<foods.length; i++){
        let data = foods[i].split(" ");
        let fileName = data[0];
        let foodName = data[1];
        console.log(fileName);
        html += `<img class="img-thumb-imgs" src="./images/${fileName}.jpg" data-index="${i}">`;
    }
    imgThumb.innerHTML = html;

}

init();

imgThumbImgs = document.querySelectorAll(".img-thumb-imgs");
for(let i=0; i<imgThumbImgs.length; i++){
    imgThumbImgs[i].addEventListener("click", ()=>{
        let index = imgThumbImgs[i].dataset.index;
        let data = foods[index].split(" ");
        let fileName = data[0];
        let foodName = data[1];
        let imgMain = document.querySelector(".img-view");
        let imgMainText = document.querySelector("#foodName");
        imgMain.innerHTML = `<img width="200" height="150" src="./images/${fileName}.jpg">`;
        imgMainText.innerText = foodName;
    });
}