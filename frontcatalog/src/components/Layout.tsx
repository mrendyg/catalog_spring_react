import { Toaster } from "react-hot-toast"
import { Outlet } from "react-router-dom"
import Header from "./Header"

const Layout = () =>{
    return(
        <div>
        <Toaster />
        <Header />
        <div className="min-h-[62.5rem] bg-[#8d8d8d]">
        
            <Outlet />
  
          
        </div>
      </div>

    )
}

export default Layout;