import {Card, CardActions, CardContent, Container, Divider, Paper, Stack, Typography} from "@mui/material";
import {Button, TextField} from "@mui/material";

export function LoginPage() {
    return (
        <div>
            <Container fixed sx={{
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                height: "50vh"
            }}>
                <Paper elevation={3}>
                <Card>
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                            Войти
                        </Typography>
                        <Stack spacing={2}>
                        <TextField
                            required
                            id="outlined-required"
                            label="Обязательно для заполнения"
                        />
                        <TextField
                            id="outlined-password-input"
                            label="Обязательно для заполнения"
                            required
                            type="password"
                            />
                        </Stack>
                    </CardContent>
                    <CardActions>
                        <Button size="large" variant={"outlined"} color={"warning"}>Войти</Button>
                    </CardActions>
                </Card>
                </Paper>
            </Container>
        </div>
    )
}