# Generated by Django 4.2.8 on 2024-01-02 04:04

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Department',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('title', models.CharField(max_length=32, verbose_name='标题')),
            ],
        ),
        migrations.CreateModel(
            name='UserInfo',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=16)),
                ('pwd', models.CharField(max_length=16)),
                ('gender', models.SmallIntegerField(choices=[(1, '男'), (2, '女')])),
                ('department', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='app02.department')),
            ],
        ),
    ]