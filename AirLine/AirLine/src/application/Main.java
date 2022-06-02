package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {

	public LinkedList<Flights> LFlights = new LinkedList<Flights>();

	public static void main(String[] args) throws FileNotFoundException {

		launch(args);
	}

	@Override
	public void start(Stage stage) throws FileNotFoundException {
		read();
		scene1(stage);
	}

	public void read() {

		File plan = new File("plan.txt");
		File passenger = new File("passenger.txt");

		try {

			Scanner sPlan = new Scanner(plan);
			Scanner sPassenger = new Scanner(passenger);

			while (sPlan.hasNext()) {
				String lPlan = sPlan.nextLine();
				String[] tkzPlan = lPlan.split(",");
				Flights f = new Flights(Integer.parseInt(tkzPlan[0]), tkzPlan[1], tkzPlan[2], tkzPlan[3],
						Integer.parseInt(tkzPlan[4]));

				LFlights.insertion(f);
			}
			while (sPassenger.hasNext()) {

				String lpass = sPassenger.nextLine();
				System.out.println(lpass);
				String[] tkzPassenger = lpass.split(",");

				Snode<Flights> curr = LFlights.getHead();
				while (curr != null) {

					if ((curr.getData().getFlightNum()) == Integer.parseInt(tkzPassenger[0])) {
						Paseenger p = new Paseenger(Integer.parseInt(tkzPassenger[0]),
								Integer.parseInt(tkzPassenger[1]), tkzPassenger[2], Double.parseDouble(tkzPassenger[3]),
								tkzPassenger[4], tkzPassenger[5]);
						curr.getData().isertPassenger(p);
					}
					curr = curr.getNext();
				}
			}

			sPassenger.close();
			sPlan.close();

		} catch (FileNotFoundException e) {
			System.out.println("" + e);
		}
	}

	public void isertflight(Flights f) {
		LFlights.insertion(f);
	}

	public void scene1(Stage stage) {

		BorderPane bp = new BorderPane();

		Image image = new Image("111.jpg");
		ImageView im = new ImageView(image);
		im.setFitHeight(330);
		im.setFitWidth(430);

		bp.setCenter(im);

		VBox vb = new VBox(20);

		Button pDF = new Button("Display flight information");
		Button pDP = new Button("Display passenger information");
		Button pEF = new Button("add/edit flight");
		Button pRT = new Button("reseve a ticket");
		Button pCR = new Button("cancle a revervation");
		Button pCTR = new Button("check if ticket reverved");
		Button pSP = new Button("serch for passenger");
		Button pE = new Button("exit");

		vb.getChildren().addAll(pDF, pDP, pEF, pRT, pCR, pCTR, pSP, pE);

		bp.setRight(vb);

		Scene scene1 = new Scene(bp, 630, 350);
		stage.setScene(scene1);
		stage.setTitle("flight ............");
		stage.show();

		pDF.setOnAction(e -> {
			cene2(stage);
		});
		pDP.setOnAction(e -> {
			sene3(stage);
		});
		pEF.setOnAction(e -> {
			cene4(stage);
		});
		pRT.setOnAction(e -> {
			sene5(stage);
		});
		pCR.setOnAction(e -> {
			cene6(stage);
		});
		pCTR.setOnAction(e -> {
			cene7(stage);
		});
		pSP.setOnAction(e -> {
			cene8(stage);
		});
		pE.setOnAction(e -> {
			stage.close();
		});

	}

	// display flight information
	public void cene2(Stage stage) {

		BorderPane bp2 = new BorderPane();

		Label l21 = new Label("flight information");
		bp2.setTop(l21);
		BorderPane.setAlignment(l21, Pos.CENTER);

		Label l22 = new Label();
		bp2.setCenter(l22);
		BorderPane.setAlignment(l22, Pos.CENTER);

		Button b2 = new Button("display");
		bp2.setBottom(b2);
		BorderPane.setAlignment(b2, Pos.CENTER);

		Scene scene2 = new Scene(bp2, 950, 650);

		stage.setScene(scene2);
		stage.setTitle("display flight information");
		stage.show();

		b2.setOnAction(e -> {
			l22.setText(LFlights.display());
		});

	}

//	 Display Passengers information for a specific flight
	public void sene3(Stage stage) {

		BorderPane bp3 = new BorderPane();

		HBox hb3 = new HBox(20);

		TextField tf3 = new TextField("specific flight");
		Button b3 = new Button("done");

		hb3.getChildren().addAll(tf3, b3);

		bp3.setBottom(hb3);
		BorderPane.setAlignment(hb3, Pos.CENTER);

		Label l31 = new Label();
		bp3.setCenter(l31);
		BorderPane.setAlignment(l31, Pos.CENTER);

		Label l32 = new Label("Display Passengers information for a specific flight");
		bp3.setTop(l32);
		BorderPane.setAlignment(l32, Pos.CENTER);

		Scene scene3 = new Scene(bp3, 630, 350);
		stage.setScene(scene3);
		stage.setTitle("flight ............");
		stage.show();

		b3.setOnAction(e -> {

			Snode<Flights> temp = LFlights.getHead();
			int n = 0;

			if (temp != null) {
				while (temp != null) {

					Flights f = temp.getData();

					if (f.getFlightNum() == Integer.parseInt(tf3.getText())) {
						l31.setText(f.LPaseenger.display());
						n = 1;
						return;
					} else
						temp = temp.getNext();
				}
			}
			if (n == 0)
				l31.setText("no items");
		});
	}

	// Add/Edit flight ==== has 2 sene
	public void cene4(Stage stage) {

		BorderPane bp4 = new BorderPane();

		Button b41 = new Button("add flight");
		Button b42 = new Button("edit flight");

		Label l4 = new Label("Add/Edit flight..");

		VBox vb4 = new VBox(20);

		vb4.getChildren().addAll(l4, b41, b42);

		bp4.setCenter(vb4);
		BorderPane.setAlignment(vb4, Pos.TOP_CENTER);

		Scene scene4 = new Scene(bp4, 630, 350);
		stage.setScene(scene4);
		stage.setTitle("Add/Edit flight");
		stage.show();

		b41.setOnAction(e -> {
			seneAddFlight(stage);
		});

		b42.setOnAction(e -> {
			seneEditFlight(stage);
		});

	}

	// add flight
	public void seneAddFlight(Stage stage) {

		Label l0 = new Label("add flight..");

		BorderPane bp0 = new BorderPane();

		GridPane gp = new GridPane();
		gp.setVgap(20);
		gp.setHgap(20);

		bp0.setTop(l0);
		BorderPane.setAlignment(l0, Pos.TOP_CENTER);

		gp.add(new Label("flightNum"), 0, 0);
		gp.add(new Label("ariLine"), 0, 1);
		gp.add(new Label("sorce"), 0, 2);
		gp.add(new Label("distantion"), 0, 3);
		gp.add(new Label("capacty"), 0, 4);

		TextField tf0 = new TextField("");
		TextField tf1 = new TextField("");
		TextField tf2 = new TextField("");
		TextField tf3 = new TextField("");
		TextField tf4 = new TextField("");

		gp.add(tf0, 1, 0);
		gp.add(tf1, 1, 1);
		gp.add(tf2, 1, 2);
		gp.add(tf3, 1, 3);
		gp.add(tf4, 1, 4);

		bp0.setCenter(gp);
		BorderPane.setAlignment(gp, Pos.TOP_CENTER);

		HBox vb0 = new HBox(20);

		Button b01 = new Button("add");
		Button b02 = new Button("back");

		vb0.getChildren().addAll(b01, b02);

		bp0.setBottom(vb0);
		BorderPane.setAlignment(vb0, Pos.TOP_CENTER);

		Scene scene0 = new Scene(bp0, 300, 300);
		stage.setScene(scene0);
		stage.setTitle("Add/Edit flight");
		stage.show();

		b01.setOnAction(e -> {
			int n1 = Integer.parseInt(tf0.getText());
			int n2 = Integer.parseInt(tf4.getText());
			LFlights.insertion(new Flights(n1, tf1.getText(), tf2.getText(), tf3.getText(), n2));
		});

		b02.setOnAction(e -> {
			scene1(stage);
		});
	}

	// edit flight
	public void seneEditFlight(Stage stage) {

		Label l0 = new Label("edit flight..");
		BorderPane bp0 = new BorderPane();

		GridPane gp = new GridPane();
		gp.setVgap(20);
		gp.setHgap(20);

		bp0.setTop(l0);
		BorderPane.setAlignment(l0, Pos.TOP_CENTER);

		gp.add(new Label("previos flightNum"), 0, 0);
		gp.add(new Label("flightNum"), 0, 1);
		gp.add(new Label("ariLine"), 0, 2);
		gp.add(new Label("sorce"), 0, 3);
		gp.add(new Label("distantion"), 0, 4);
		gp.add(new Label("capacty"), 0, 5);

		TextField tf0 = new TextField("");
		TextField tf1 = new TextField("");
		TextField tf2 = new TextField("");
		TextField tf3 = new TextField("");
		TextField tf4 = new TextField("");
		TextField tf5 = new TextField("");

		gp.add(tf0, 1, 0);
		gp.add(tf1, 1, 1);
		gp.add(tf2, 1, 2);
		gp.add(tf3, 1, 3);
		gp.add(tf4, 1, 4);
		gp.add(tf5, 1, 5);

		Label l = new Label("");
		gp.add(l, 1, 6);

		bp0.setCenter(gp);
		BorderPane.setAlignment(gp, Pos.TOP_CENTER);

		HBox vb0 = new HBox(20);

		Button b01 = new Button("edit");
		Button b02 = new Button("back");

		vb0.getChildren().addAll(b01, b02);

		bp0.setBottom(vb0);
		BorderPane.setAlignment(vb0, Pos.TOP_CENTER);

		Scene scene0 = new Scene(bp0, 300, 350);
		stage.setScene(scene0);
		stage.setTitle("Edit flight");
		stage.show();

		b02.setOnAction(r -> {
			scene1(stage);
		});

		b01.setOnAction(r -> {

			Snode<Flights> curr = LFlights.getHead();

			while (curr != null) {

				if (curr.getData().getFlightNum() == Integer.parseInt(tf0.getText())) {
					curr.getData().setFlightNum(Integer.parseInt(tf1.getText()));
					curr.getData().setAriLine(tf2.getText());
					curr.getData().setSorce(tf3.getText());
					curr.getData().setDistantion(tf4.getText());
					curr.getData().setCapacty(Integer.parseInt(tf5.getText()));
					l.setText("founded and done");
					break;
				} else
					curr = curr.getNext();
			}
			if (l.getText().equalsIgnoreCase("founded and done")) {

			} else
				l.setText("not found");
		});
	}

	// Reserve a ticket for a specific flight
	public void sene5(Stage stage) {

		BorderPane bp5 = new BorderPane();

		Label l5 = new Label("Reserve a ticket ....");
		bp5.setTop(l5);
		BorderPane.setAlignment(l5, Pos.TOP_CENTER);

		GridPane gp5 = new GridPane();
		gp5.setVgap(20);
		gp5.setHgap(20);

		gp5.add(new Label("flightNum"), 0, 0);
		gp5.add(new Label("tacket"), 0, 1);
		gp5.add(new Label("fullName"), 0, 2);
		gp5.add(new Label("passportNumber"), 0, 3);
		gp5.add(new Label("nationalty"), 0, 4);
		gp5.add(new Label("dateOfParth"), 0, 5);

		TextField tf0 = new TextField("");
		TextField tf1 = new TextField("");
		TextField tf2 = new TextField("");
		TextField tf3 = new TextField("");
		TextField tf4 = new TextField("");
		TextField tf5 = new TextField("");

		gp5.add(tf0, 1, 0);
		gp5.add(tf1, 1, 1);
		gp5.add(tf2, 1, 2);
		gp5.add(tf3, 1, 3);
		gp5.add(tf4, 1, 4);
		gp5.add(tf5, 1, 5);

		bp5.setCenter(gp5);
		BorderPane.setAlignment(gp5, Pos.TOP_CENTER);

		HBox hb5 = new HBox(20);
		Button b51 = new Button("Reserve");
		Button b52 = new Button("back");
		hb5.getChildren().addAll(b51, b52);

		bp5.setBottom(hb5);
		BorderPane.setAlignment(hb5, Pos.TOP_CENTER);

		Scene scene5 = new Scene(bp5, 300, 320);
		stage.setScene(scene5);
		stage.setTitle("Reserve a ticket for a specific flight");
		stage.show();

		b51.setOnAction(e -> {

			Paseenger p = new Paseenger(Integer.parseInt(tf0.getText()), Integer.parseInt(tf1.getText()), tf2.getText(),
					Double.parseDouble(tf3.getText()), tf4.getText(), tf5.getText());

			Snode<Flights> curr = LFlights.getHead();

			while (curr != null) {

				if (curr.getData().getFlightNum() == Integer.parseInt(tf0.getText())) {
					curr.getData().LPaseenger.insertion(p);
					break;
				} else
					curr = curr.getNext();
			}
		});

		b52.setOnAction(e -> {
			scene1(stage);
		});
	}

	// Cancel a reservation

	public void cene6(Stage stage) {

		BorderPane bp6 = new BorderPane();

		GridPane gp6 = new GridPane();
		gp6.setVgap(20);
		gp6.setHgap(20);

		Label l6 = new Label("Cancel a reservation");
		bp6.setTop(l6);
		BorderPane.setAlignment(l6, Pos.TOP_CENTER);

		gp6.add(new Label("flightNum"), 0, 0);
		gp6.add(new Label("tacket"), 0, 1);
		gp6.add(new Label("fullName"), 0, 2);
		gp6.add(new Label("passportNumber"), 0, 3);
		gp6.add(new Label("nationalty"), 0, 4);
		gp6.add(new Label("dateOfParth"), 0, 5);

		TextField tf0 = new TextField("");
		TextField tf1 = new TextField("");
		TextField tf2 = new TextField("");
		TextField tf3 = new TextField("");
		TextField tf4 = new TextField("");
		TextField tf5 = new TextField("");

		gp6.add(tf0, 1, 0);
		gp6.add(tf1, 1, 1);
		gp6.add(tf2, 1, 2);
		gp6.add(tf3, 1, 3);
		gp6.add(tf4, 1, 4);
		gp6.add(tf5, 1, 5);

		bp6.setCenter(gp6);
		BorderPane.setAlignment(gp6, Pos.BOTTOM_CENTER);

		HBox hb6 = new HBox(20);
		Button b61 = new Button("done");
		Button b62 = new Button("cancle");

		hb6.getChildren().addAll(b61, b62);
		bp6.setBottom(hb6);
		BorderPane.setAlignment(hb6, Pos.TOP_CENTER);

		Scene scene6 = new Scene(bp6, 300, 350);
		stage.setScene(scene6);
		stage.setTitle("Cancel a reservation.......");
		stage.show();

		b61.setOnAction(e -> {

			Snode<Flights> curr = LFlights.getHead();

			while (curr != null) {
				Snode<Paseenger> temp = curr.getData().LPaseenger.getHead();
				while (temp != null) {

					if (temp.getData().getTacket() == Integer.parseInt(tf1.getText())) {
						curr.getData().delePassenger(temp.getData());
						break;
					}
					temp = temp.getNext();
				}
				curr = curr.getNext();
			}

		});

		b62.setOnAction(e -> {
			scene1(stage);
		});

	}

	// Check whether a ticket is reserved for a particular person
	public void cene7(Stage stage) {

		BorderPane bp7 = new BorderPane();

		Label l71 = new Label("Check whether a ticket is reserved for a particular person");
		bp7.setTop(l71);
		BorderPane.setAlignment(l71, Pos.TOP_CENTER);

		HBox hb7 = new HBox(20);
		TextField tf7 = new TextField("enter ticket number to check");
		Button b7 = new Button("Check");
		hb7.getChildren().addAll(tf7, b7);
		bp7.setBottom(hb7);
		BorderPane.setAlignment(hb7, Pos.BOTTOM_CENTER);

		Label l72 = new Label("  ");
		bp7.setCenter(l72);
		BorderPane.setAlignment(l72, Pos.TOP_CENTER);

		Scene scene7 = new Scene(bp7, 630, 350);
		stage.setScene(scene7);
		stage.setTitle("Check whether a ticket is reserved for a particular person.......");
		stage.show();

		b7.setOnAction(e -> {
			Snode<Flights> curr = LFlights.getHead();

			int n = 0;
			while (curr != null) {
				Snode<Paseenger> temb = curr.getData().LPaseenger.getHead();
				while (temb != null) {
					if (temb.getData().getTacket() == Integer.parseInt(tf7.getText())) {
						l72.setText("sorry he actully reserved");
						n = 1;
						break;
					} else
						temb = temb.getNext();
				}
				curr = curr.getNext();
			}
			if (n == 0) {
				l72.setText("not reserved");
			}
		});

	}

//	// . Search for a specific passenger and print all his information (Flight
	// number, Ticket number, Full name, Passport number, Nationality, andBirthdate)
	public void cene8(Stage stage) {

		BorderPane bp8 = new BorderPane();

		Label l81 = new Label("Search for a specific passenger and print all his information");
		bp8.setTop(l81);
		BorderPane.setAlignment(l81, Pos.TOP_CENTER);

		HBox hb8 = new HBox(20);

		TextField tf8 = new TextField("enter passpor tNumber :");
		Button b8 = new Button("done");

		hb8.getChildren().addAll(tf8, b8);
		bp8.setBottom(hb8);
		BorderPane.setAlignment(hb8, Pos.TOP_CENTER);

		Label l82 = new Label("");
		bp8.setCenter(l82);
		BorderPane.setAlignment(l82, Pos.TOP_CENTER);

		Scene scene8 = new Scene(bp8, 630, 350);
		stage.setScene(scene8);
		stage.setTitle(" Search for a specific passenger and print all his information.......");
		stage.show();

		b8.setOnAction(e -> {

			Snode<Flights> curr = LFlights.getHead();
			int n = 0;

			while (curr != null) {
				if (curr.getData() != null) {
					// curr.getData().LPaseenger.search(Double.parseDouble( tf8.getText()));
					Snode<Paseenger> temb = curr.getData().LPaseenger.getHead();
					while (temb != null) {
						if (temb.getData().getPassportNumber() == Double.parseDouble(tf8.getText())) {
							l82.setText(temb.getData().toString());
							n = 1;
							break;
						} else
							temb = temb.getNext();
					}
					curr = curr.getNext();
				}
				if (n == 0) {
					l82.setText("no passenders founded");
				}
			}
		});

	}
}
