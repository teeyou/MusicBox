# 2022.12.22 19장 BeatBox

- MVC - 규모가 작고 간단한 앱에 좋음.쉽고 빨리 개발가능   
규모가 커지면 액티비티나 프래그먼트의 규모가 커지면서 이해하기 어려워짐   
컨트롤러를 분할할 필요가 있음   
   
- MVVM - View와 밀접한 컨트롤러 코드를 레이아웃으로 옮길 수 있음    
동적인 데이터를 처리하는 코드의 일부를 View Model 클래스에 넣어서    
테스트 및 검증도 쉽게 가능   
    
아키텍처에서 말하는 ViewModel과 jetpack의 VIewModel은 같은게 아님   
jetpack ViewModel은 액티비티,프래그먼트의 생명주기에 맞춰 데이터 유지관리   
아키텍쳐의 ViewModel은 jetpack의 ViewModel을 써서 구현할 수도 있지만 안 써도 됨   
   
- MusicBox는 databinding, MVVM 적용해서 개발   
   
asset은 리소스처럼 APK에 포함되지만 관리하는 시스템이 없어서 자동으로 대응불가   
일반적으로 리소스를 쓰는게 좋음. 대부분 게임앱은 그래픽,음원을 에셋으로 사용   
   
databinding을 쓰면 자동으로 xml에 대응하는 클래스를 생성해줌   
xml에서 layout으로 감싸고 data태그 안에 variable 사용 @{}를 써서 variable사용   
@{}안에 속성값,람다식 사용가능   

jetpack에서 제공하는 ViewModel이 아닌    
사용자 정의 ViewModel 클래스를 BaseObservable을 상속받아서 구현해서 사용   
xml에서"" 안에 백틱 사용해서 string 표현 가능   
BaseObservable 대신에 LiveData를 사용해도 됨   
   
안드로이드 오디오 API - SoundPool.Builder(), MediaPlayer   
SoundPool은 짧은 오디오 재생할 때 사용   
 
