import React from "react";
import "../../css/about.css";
import { Link } from "react-router-dom";

const AboutUs = () => {
    return (
        <div className="about">
            <div className="about-section">
                <section className="d-flex align-items-center section-storis">
                    <div className="col-6 d-flex justify-content-end left-column">
                        <img
                            src="https://scontent-hkt1-2.xx.fbcdn.net/v/t39.30808-6/215358302_3010202009260042_7197260569885947401_n.jpg?_nc_cat=104&ccb=1-5&_nc_sid=730e14&_nc_ohc=t92ulIzXCZQAX_UBdHc&_nc_ht=scontent-hkt1-2.xx&oh=49051957528fec48743c821d5b4287d4&oe=61B64580"
                            alt=""
                            width="100%"
                        />
                    </div>
                    <div className="col-6 d-grid right-column">
                        <div className="py-3 stories">
                            <h1>Câu chuyện về SGES</h1>
                        </div>
                        <div className="stories-content">
                            <p>
                                Với ý tưởng ấp ủ từ những năm tháng đại học, SGES bắt đầu đi vào thị
                                trường local brand vào giữa năm 2015. Kể từ ngày đầu tiên, đúng với
                                tên gọi của mình Saigonese Clothing - SGES, chúng tôi luôn mong muốn
                                mang đến cho giới trẻ Sài Thành những trải nghiệm tốt nhất về thời
                                trang đường phố, trẻ trung và năng động.
                            </p>
                        </div>
                    </div>
                </section>
                <div className="section-clothing">
                    <div className="d-flex align-items-center clothing-content">
                        <div className="col-6 left-column d-flex justify-content-center align-items-center left-column">
                            <div className="clothing-body text-center">
                                <div className="clothing-title">
                                    <h1>SGES Clothing</h1>
                                </div>
                                <div className="clothing-content">
                                    <p>
                                        Kể từ ngày bắt đầu hoạt động, chúng tôi làm việc không ngừng
                                        nghỉ để mở rộng đa dạng các mẫu mã sản phẩm thời trang chất
                                        lượng nhất, giá cả hợp lý nhất đến tất cả các bạn trên toàn
                                        nước. Bộ sản phẩm của SGES mang phong cách đơn giản, cá
                                        tính, năng động phù hợp cho cả nam và nữ. Hãy đến với SGES
                                        để thời trang mang phong cách riêng của bạn
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div className="col-6 right-column right-column">
                            <img
                                src="https://scontent-hkg4-2.xx.fbcdn.net/v/t39.30808-6/251443232_3088602194753356_8468644083226095237_n.jpg?_nc_cat=111&ccb=1-5&_nc_sid=730e14&_nc_ohc=YQxOOC4lCAsAX-VCSG9&_nc_ht=scontent-hkg4-2.xx&oh=ba781cc96e8d32a219499452cfe11786&oe=61B81FC1"
                                alt=""
                                width="100%"
                            />
                        </div>
                    </div>
                </div>
                <div className="banner">
                    <img
                        src="https://static.wixstatic.com/media/8220c33dd55d4c9582afa649c952a01a.jpg/v1/fill/w_1903,h_500,fp_0.50_0.50,q_85,usm_0.66_1.00_0.01/8220c33dd55d4c9582afa649c952a01a.webp"
                        alt=""
                        width="100%"
                    />
                </div>
                <div className="get-in-touch d-flex justify-content-center">
                    <div className="col-6 d-grid">
                        <h1>Get in touch</h1>
                        <span>756 Cách mạng tháng 8, Phường 5, Quận Tân Bình</span>
                        <span>saigonese.unisex2015@gmail.com</span>
                        <span>0707191381</span>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AboutUs;
