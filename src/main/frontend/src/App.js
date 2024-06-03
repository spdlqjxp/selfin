import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Login from "./pages/Login";
import Main from "./pages/Main";
import Edit from "./pages/Edit";
import MyPage from "./pages/MyPage";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/pages/login_page" element={<Login/>}/>
          <Route path="/pages/main" element={<Main/>}/>
          <Route path="/pages/edit" element={<Edit/>}/>
          <Route path={"/pages/mypage"} element={<MyPage/>}/>
        </Routes>
      </BrowserRouter>
  );
}

export default App;
