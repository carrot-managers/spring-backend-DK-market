# spring-backend-DK-market
# BACK
Spring, React 사용 당근마켓 클론코딩

###### lecture : DK-opensource SW
###### backend developer : 32183490 이정우, 32197330 손명진

# API 설계

User

기능 | Method | Url | Return
:--: | :--: | :--: | :--:
회원가입 | POST | user/signup | User
로그인 | POST | user/signin | User
로그아웃 | POST | user/logout | Long
현재 로그인한 유저 | GET | user/current | User

Goods

기능 | Method | Url | Return
:--: | :--: | :--: | :--:
전체 상품 조회 | GET | goodsList/ | List<Goods>
특정 상품 조회 | GET | goods/{id}/ | Goods
상품 등록 | POST | goods/create | Long
상품 수정 | PUT | goods/{id}/edit/ | -
상품 삭제 | DELETE | goods/{id}/remove | -

