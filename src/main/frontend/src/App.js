import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Login from "./pages/Login";
import Main from "./pages/Main";
import Edit from "./pages/Edit";
import MyPage from "./pages/MyPage";
import Edit_fin from "./pages/Edit_fin";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/pages/login_page" element={<Login/>}/>
          <Route path="/pages/main" element={<Main/>}/>
          <Route path="/pages/edit" element={<Edit/>}/>
          <Route path={"/pages/mypage"} element={<MyPage/>}/>
          <Route path={"/pages/edit_fin"} element={<Edit_fin/>}/>
        </Routes>
      </BrowserRouter>
  );
}

export default App;
