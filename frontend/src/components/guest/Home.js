import { Component } from "react";
import '../../App.css';

class Home extends Component {
    render() {
        return (
            <div>
                <div>
                    <div className="row m-0" style={{ backgroundColor: '#F5F3F2' }}>
                        <div className="col-sm-2">
                        </div>
                        <div className="col-sm-8">
                            <div className="row">
                                <div className="col p-0 ps-2">
                                    <img src="https://static.wixstatic.com/media/a9ff3b_3be32fd5866944a0b2bd867c8e0dbaf9.jpg/v1/fill/w_613,h_588,al_c,q_85,usm_0.66_1.00_0.01/a9ff3b_3be32fd5866944a0b2bd867c8e0dbaf9.webp" className="img-fluid" alt="" />
                                </div>
                                <div className="col p-0 pe-2">
                                    <div className="w-100 h-100" style={{ backgroundColor: '#FFE9E3', paddingTop: '33%' }}>
                                        <h3 className="text-center">SULTRY &amp; SMART</h3>
                                        <p className="text-center">HOT SPRING LOOKS</p>
                                        <h3 className="text-center">Shop women</h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="col-sm-2" />
                    </div>
                    <div className="row m-0" style={{ backgroundColor: '#D4E4E0' }}>
                        <div className="col-sm-2">
                        </div>
                        <div className="col-sm-8">
                            <div className="row">
                                <div className="col p-0 ps-2">
                                    <div className="w-100 h-100" style={{ backgroundColor: '#A3C7BD', paddingTop: '33%', color: 'white' }}>
                                        <h3 className="text-center">ELEGANT &amp; SLICK</h3>
                                        <p className="text-center">GET READY FOR SUMMER</p>
                                        <h3 className="text-center">Shop men</h3>
                                    </div>
                                </div>
                                <div className="col p-0 pe-2">
                                    <img src="https://static.wixstatic.com/media/a9ff3b_e3d29ce5f3e946e2b2b4c710e6e7ca75.jpg/v1/fill/w_613,h_588,al_c,q_85,usm_0.66_1.00_0.01/a9ff3b_e3d29ce5f3e946e2b2b4c710e6e7ca75.webp" className="img-fluid" alt="" />
                                </div>
                            </div>
                        </div>
                        <div className="col-sm-2" />
                    </div>
                </div>
                <div>
                    <div className="p-4">
                        <h3 className="text-center">NEW ARRIVALS</h3>
                    </div>
                    <div className="row m-0">
                        <div className="col-md-2" />
                        <div className="col-md-8">
                            <div className="row text-center">
                                <div className="col-md-4 ps-2 pe-2">
                                    <img src="https://static.wixstatic.com/media/84770f_92ad288f7eb849c68652826216de56dc.png/v1/fill/w_394,h_518,al_c,q_90,usm_0.66_1.00_0.01/84770f_92ad288f7eb849c68652826216de56dc.webp" className="img-fluid" alt="" />
                                    <div className="text-center p-4" style={{ backgroundColor: '#DADAD7' }}>
                                        <h5 className="fts-normal">DENIM</h5>
                                        <span>$ 45.00</span>
                                    </div>
                                </div>
                                <div className="col-md-4 ps-2 pe-2">
                                    <img src="https://static.wixstatic.com/media/84770f_fa2cb753b49b43faa1e9b3da2e8f72c0.png/v1/fill/w_396,h_518,al_c,q_90,usm_0.66_1.00_0.01/84770f_fa2cb753b49b43faa1e9b3da2e8f72c0.webp" className="img-fluid" alt="" />
                                    <div className="text-center p-4" style={{ backgroundColor: '#DADAD7' }}>
                                        <h5 className="fts-normal">DENIM</h5>
                                        <span>$ 45.00</span>
                                    </div>
                                </div>
                                <div className="col-md-4 ps-2 pe-2">
                                    <img src="https://static.wixstatic.com/media/84770f_8745e3f04d8e4662ba23b4d575602616.png/v1/fill/w_399,h_518,al_c,q_90,usm_0.66_1.00_0.01/84770f_8745e3f04d8e4662ba23b4d575602616.webp" className="img-fluid" alt="" />
                                    <div className="text-center p-4" style={{ backgroundColor: '#DADAD7' }}>
                                        <h5 className="fts-normal">DENIM</h5>
                                        <span>$ 45.00</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="col-md-2" />
                    </div>
                </div>
                <div className="mt-5 text-center">
                    <h1>GET ON THE LIST</h1>
                    <h5>and be the first to shop new arrivals and exclusive promotions.</h5>
                    <div className="row m-4">
                        <div className="col-md-4" />
                        <div className="col-md-4 ps-5 pe-5">
                            <form>
                                <input type="email" className="form-control border border-3 rounded-0" placeholder="Enter your email here" />
                                <button className="mt-3 p-0 pt-2 btn w-100 rounded-0" style={{ backgroundColor: '#A3C7BD' }}>
                                    <h5 style={{ color: 'white' }}>Subscribe Now</h5>
                                </button>
                            </form>
                        </div>
                        <div className="col-md-4" />
                    </div>
                </div>
            </div>
        )
    }
}

export default Home;